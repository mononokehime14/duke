import java.util.Scanner;

public class Ui {
    public void showLoadingError(){
        System.out.println("There is no existing list");
    }
    public void showWelcome(){
        String optionline = "---------------------------------------\n";
        String welcome  = optionline+ "Hello! I'm Duke\n"+ "What can I do for you?\n"+optionline;
        System.out.println(welcome);
        return;
    }
    public String readCommand(){
        Scanner input  = new Scanner(System.in);
        String userinput=input.nextLine();
        return userinput;
    }
    public void showLine(){
        System.out.println("---------------------------------------\n");
    }
    public void showError(String error){

    }
    public void sayGoodbye(){
        System.out.println("Bye. Hope to see you again soon!");
    }
}
