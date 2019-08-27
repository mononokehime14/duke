import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Duke {
    //level-3
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        String optionline = "-----------------------------\n";
        Scanner input  = new Scanner(System.in);
        HashMap<String,Integer> Hashlist = new HashMap<String,Integer>();

        System.out.println(optionline);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println(optionline);
        String userinput;
        String checkmark  ="\u2713";
        String crossmark = "\u2717";
        while(!((userinput=input.nextLine()).equals("bye"))){
            String[] splitstring  = userinput.split(" ");

            if(userinput.equals("list")) {
                System.out.println(optionline);
                System.out.println("Here are the tasks in your list:");
                int count = 0;
                for (Map.Entry<String,Integer> entry : Hashlist.entrySet()) {
                    count++;
                    if (entry.getValue() == 0) {
                        System.out.println(count + "." + " ["+crossmark+"] " + entry.getKey());
                    } else {
                        System.out.println(count + "." +" ["+checkmark+"] " + entry.getKey());
                    }
                }
                System.out.println(optionline);
            }else if(splitstring[0].equals("done")){
                System.out.println(optionline);
                System.out.println("Nice! I've marked this task as done: ");
                int count = 0;
                for (Map.Entry<String,Integer> entry : Hashlist.entrySet()) {
                    count++;
                    if(count == Integer.parseInt(splitstring[1])){
                        Hashlist.put(entry.getKey(),1);
                        System.out.println(" ["+checkmark+"] "+ entry.getKey());
                    }
                }
                System.out.println(optionline);
            }else {
                System.out.println(optionline);
                System.out.println("added: " + userinput);
                System.out.println(optionline);
                Hashlist.put(userinput,0);
            }
        }
        System.out.println(optionline);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(optionline);
    }
}