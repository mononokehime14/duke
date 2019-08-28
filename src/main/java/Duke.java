import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

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
//        String checkmark  ="\u2713";
//        String crossmark = "\u2717";
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
                        while (i < splitstring.length) {
                            time = time + " " + splitstring[i];
                            i++;
                        }
                        System.out.println(optionline);
                        System.out.println("Got it. I've added this task:");
                        Task t = new Deadline(description, time, "D");
                        Tasklist.add(t);
//                System.out.println("  ["+t.Type+"]["+t.getStatusIcon()+"] " + t.description + " " + t.getTime());
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
                        while (i < splitstring.length) {
                            time = time + " " + splitstring[i];
                            i++;
                        }
                        System.out.println(optionline);
                        System.out.println("Got it. I've added this task:");
                        Task t = new Event(description, time, "E");
                        Tasklist.add(t);
//                System.out.println("  ["+t.Type+"]["+t.getStatusIcon()+"] " + t.description + " " + t.getTime());
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
                        //System.out.println("  ["+t.Type+"]["+t.getStatusIcon()+"] " + t.description + " " + t.getTime());
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