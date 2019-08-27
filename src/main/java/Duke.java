import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Duke {
//level-1
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        String optionline = "-----------------------------\n";
        Scanner input  = new Scanner(System.in);

        System.out.println(optionline);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println(optionline);
        String userinput;

        while(!((userinput=input.nextLine()).equals("bye"))){
            System.out.println(optionline);
            System.out.println(userinput);
            System.out.println(optionline);
        }
        System.out.println(optionline);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(optionline);
    }
}