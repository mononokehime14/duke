import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Duke {
    //level-3 A-Classes
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        String optionline = "---------------------------------------\n";
        Scanner input  = new Scanner(System.in);
//        HashMap<String,Integer> Hashlist = new HashMap<String,Integer>();
        ArrayList<Task> Tasklist = new ArrayList<Task>();
        System.out.println(optionline);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println(optionline);
        String userinput;

        File checkfile = new File("./docs/tasklist.txt");
        if(checkfile.exists()){
            try (Scanner s = new Scanner(new FileReader("./docs/tasklist.txt"))) {
                while (s.hasNext()) {
                    String content = s.nextLine();
                    String[] tempsplit = content.split("/");
                    String description = tempsplit[2];
                    String time = tempsplit[0].equals("T") ? "" : tempsplit[3];
                    String Type = tempsplit[0];
                    if(Type.equals("T")) {
                        Task t = new Todo(description, time, Type);
                        if (tempsplit[1].equals("done")) {
                            t.markAsDone();
                        }
                        Tasklist.add(t);
                    }else if(Type.equals("D")){
                        Task t = new Deadline(description, time, Type);
                        if (tempsplit[1].equals("done")) {
                            t.markAsDone();
                        }
                        Tasklist.add(t);
                    }else{
                        Task t = new Event(description, time, Type);
                        if (tempsplit[1].equals("done")) {
                            t.markAsDone();
                        }
                        Tasklist.add(t);
                    }
                }
            }catch(Exception e){System.out.println(e);}
        }else{
            File file = new File("./docs/tasklist.txt");
            try {
                if (file.createNewFile()) {
                    System.out.println("File is created!");
                }
            }catch(Exception e){System.out.println(e);}

        }


        while(!((userinput=input.nextLine()).equals("bye"))){
            String[] splitstring  = userinput.split(" ");

            if(userinput.equals("list")) {
                System.out.println(optionline);
                System.out.println("Here are the tasks in your list:");
                for (int i=0;i<Tasklist.size();i++){
                    String time = Tasklist.get(i).toString();
                    System.out.println((i+1)+"." + time);
                }
                System.out.println(optionline);
            }else if(splitstring[0].equals("done")){
                System.out.println(optionline);
                System.out.println("Nice! I've marked this task as done: ");
                for(int i =0 ;i<Tasklist.size();i++){
                    if(i + 1== Integer.parseInt(splitstring[1])){
                        Tasklist.get(i).markAsDone();
                        System.out.println(Tasklist.get(i).toString());
                    }
                }
                System.out.println(optionline);
                try {
                    FileOutputStream outputStream = new FileOutputStream("./docs/tasklist.txt");
                    for(int i=0;i<Tasklist.size();i++) {
                        String tempdone = Tasklist.get(i).isDone ? "done" : "notdone";
                        String outputline = Tasklist.get(i).Type+"/"+tempdone+"/"+ Tasklist.get(i).description + "/"+Tasklist.get(i).time;
                        byte[] strToBytes = outputline.getBytes();
                        outputStream.write(strToBytes);
                        outputStream.write('\n');
                    }
                    outputStream.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }else if(splitstring[0].equals("delete")){
                int removeindex=0;
                System.out.println(optionline);
                System.out.println("Noted. I've removed this task: ");
                for(int i =0 ;i<Tasklist.size();i++){
                    if(i + 1== Integer.parseInt(splitstring[1])){
                        removeindex = i;
                        System.out.println(Tasklist.get(i).toString());
                    }
                }
                boolean loopflag = true;
                for(int i =0 ;i<Tasklist.size() && loopflag;i++){
                    if(removeindex == i){
                        loopflag = false;
                        Tasklist.remove(removeindex);
                    }
                }
                System.out.println("Now you have "+Tasklist.size()+" tasks in the list.");
                System.out.println(optionline);
                try {
                    FileOutputStream outputStream = new FileOutputStream("./docs/tasklist.txt");
                    for(int i=0;i<Tasklist.size();i++) {
                        String tempdone = Tasklist.get(i).isDone ? "done" : "notdone";
                        String outputline = Tasklist.get(i).Type+"/"+tempdone+"/"+ Tasklist.get(i).description + "/"+Tasklist.get(i).time;
                        byte[] strToBytes = outputline.getBytes();
                        outputStream.write(strToBytes);
                        outputStream.write('\n');
                    }
                    outputStream.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }else if(splitstring[0].equals("deadline")){
                try {
                    if (splitstring.length == 1) {
                        throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
                    } else {
                        String description = "";
                        String time = "";
                        int i = 1;
                        while (i < splitstring.length && splitstring[i].charAt(0) != '/') {
                            description = description + " " + splitstring[i];
                            i++;
                        }
                        i = i + 1;
                        boolean flag = false;
                        int count = 0;
                        for (int j = 0; j < splitstring[i].length(); j++) {
                            if (splitstring[i].charAt(j) == '/') {
                                count++;
                            }
                        }
                        if (count == 2) flag = true;

                        while (i < splitstring.length) {
                            time = time + " " + splitstring[i];
                            i++;
                        }
                        if(flag){
                            String[] temptime = time.split(" ");
                            String[] tempdate = temptime[1].split("/");
                            Date x = new Date(tempdate[0],tempdate[1],tempdate[2],temptime[2]);
                            time = x.toString();
                        }
                        System.out.println(optionline);
                        System.out.println("Got it. I've added this task:");
                        Task t = new Deadline(description, time, "D");
                        Tasklist.add(t);
                        String outputline = "D/"+"notdone/"+ description + "/"+time;
                        try{
                            FileOutputStream outputStream = new FileOutputStream("./docs/tasklist.txt", true);
                            byte[] strToBytes = outputline.getBytes();
                            outputStream.write(strToBytes);
                            outputStream.write('\n');
                            outputStream.close();
                        }catch(Exception e){System.out.println(e);}
                        System.out.println(t.toString());
                        System.out.println("Now you have " + Tasklist.size() + " tasks in the list.");
                        System.out.println(optionline);
                    }
                }catch (DukeException ex){
                    String temp = "☹ ";
                    System.out.println(optionline);
                    System.out.println(temp + ex.getMessage());
                    System.out.println(optionline);
                }
            }else if(splitstring[0].equals("event")){
                try {
                    if (splitstring.length == 1) {
                        throw new DukeException("OOPS!!! The description of a event cannot be empty.");
                    } else {
                        String description = "";
                        String time = "";
                        int i = 1;
                        while (i < splitstring.length && splitstring[i].charAt(0) != '/') {
                            description = description + " " + splitstring[i];
                            i++;
                        }
                        i = i + 1;
                        boolean flag = false;
                        int count = 0;
                        for (int j = 0; j < splitstring[i].length(); j++) {
                            if (splitstring[i].charAt(j) == '/') {
                                count++;
                            }
                        }
                        if (count == 2) flag = true;

                        while (i < splitstring.length) {
                            time = time + " " + splitstring[i];
                            i++;
                        }
                        if(flag){
                            String[] temptime = time.split(" ");
                            String[] tempdate = temptime[1].split("/");
                            Date x = new Date(tempdate[0],tempdate[1],tempdate[2],temptime[2]);
                            time = x.toString();
                        }
                        System.out.println(optionline);
                        System.out.println("Got it. I've added this task:");
                        Task t = new Event(description, time, "E");
                        Tasklist.add(t);
                        String outputline = "E/"+"notdone/"+ description + "/"+time;
                        try{
                            FileOutputStream outputStream = new FileOutputStream("./docs/tasklist.txt", true);
                            byte[] strToBytes = outputline.getBytes();
                            outputStream.write(strToBytes);
                            outputStream.write('\n');
                            outputStream.close();
                        }catch(Exception e){System.out.println(e);}
                        System.out.println(t.toString());
                        System.out.println("Now you have " + Tasklist.size() + " tasks in the list.");
                        System.out.println(optionline);
                    }
                }catch (DukeException ex){
                    String temp = "☹ ";
                    System.out.println(optionline);
                    System.out.println(temp + ex.getMessage());
                    System.out.println(optionline);
                }
            }else if(splitstring[0].equals("todo")){
                try {
                    if (splitstring.length == 1) {
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                    }else {

                        String description = "";
                        String time = "";
                        int i = 1;
                        while (i < splitstring.length) {
                            description = description + " " + splitstring[i];
                            i++;
                        }
                        System.out.println(optionline);
                        System.out.println("Got it. I've added this task:");
                        Task t = new Todo(description, time, "T");
                        Tasklist.add(t);
                        String outputline = "T/"+"notdone/"+ description + "/"+time;;
                        System.out.println(t.toString());
                        try{
                            FileOutputStream outputStream = new FileOutputStream("./docs/tasklist.txt", true);
                            byte[] strToBytes = outputline.getBytes();
                            outputStream.write(strToBytes);
                            outputStream.write('\n');
                            outputStream.close();
                        }catch(Exception e){System.out.println(e);}
                        System.out.println("Now you have " + Tasklist.size() + " tasks in the list.");
                        System.out.println(optionline);
                    }
                }catch (DukeException ex){
                    String temp = "☹ ";
                    System.out.println(optionline);
                    System.out.println(temp + ex.getMessage());
                    System.out.println(optionline);
                }
            }else {
                try{
                    throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }catch (DukeException ex){
                    String temp = "☹ " ;
                    System.out.println(optionline);
                    System.out.println(temp + ex.getMessage());
                    System.out.println(optionline);
                }
            }
        }
        System.out.println(optionline);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(optionline);
    }
}