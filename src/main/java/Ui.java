/**
 * Ui class deals with interactions between Duke and Users, displays messages in the console.
 */

import java.util.Scanner;

public class Ui {
    /**
     * Displays loading error message if loading of txt file fails.
     */
    public void showLoadingError(){
        System.out.println("There is no existing list");
    }

    /**
     * Displays welcome message.
     */
    public void showWelcome(){
        String optionline = "---------------------------------------\n";
        String welcome  = optionline+ "Hello! I'm Duke\n"+ "What can I do for you?\n"+optionline;
        System.out.println(welcome);
        return;
    }

    /**
     * Takes in user-input, stores in the String format.
     * @return String of the whole user-input.
     */
    public String readCommand(){
        Scanner input  = new Scanner(System.in);
        String userinput=input.nextLine();
        return userinput;
    }

    /**
     * Displays optional line in the console.
     */
    public void showLine(){
        System.out.println("---------------------------------------\n");
    }
    public void showError(String error){

    }

    /**
     * Displays goodbye message in the console when existing the programme.
     */
    public void sayGoodbye(){
        System.out.println("Bye. Hope to see you again soon!");
    }
}
