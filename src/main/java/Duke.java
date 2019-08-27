import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Duke {
//Level-2
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        String optionline = "-----------------------------\n";
        Scanner input  = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();

        System.out.println(optionline);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println(optionline);
        String userinput;

        while(!((userinput=input.nextLine()).equals("bye"))){
            if(userinput.equals("list")){
                System.out.println(optionline);
                for(int i  = 0;i < list.size();i++){
                    System.out.println((i+1)+". "+ list.get(i));
                }

                System.out.println(optionline);
            }else {
                System.out.println(optionline);
                System.out.println("added: " + userinput);
                System.out.println(optionline);
                list.add(userinput);
            }
        }
        System.out.println(optionline);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(optionline);
    }
}