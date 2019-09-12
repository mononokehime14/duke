/**
 * The command class provide basic features of commands, storing them by type and content.
 * It contains override constructor function to create a Command type in different ways.
 * It contain execute function to deal with all commands that is key in as user-input, giving exception if operation goes wrong.
 */
public class Command {
    public String Type;
    public String content;

    /**
     * This constructor method create a Command class, store them by their type (string) and content (string_.
     * @param Type
     * @param content
     */
    public Command(String Type, String content){
        this.Type = Type;
        this.content = content;
    }

    /**
     * This override constructor receives String of whole user-input and parser it to get type(string) and content(string)
     * @param userinput
     */
    public Command(String userinput){
        String Type= "";
        String content = "";
        String[] splitstring = userinput.split(" ");
        Type = splitstring[0];
        int i = 1;
        while(i <  splitstring.length){
            content += " "+splitstring[i];
            i++;
        }
        this.Type = Type;
        this.content = content;

    }

    /**
     * This execute function takes in class Ui,class type Tasklist and class type Storage to update changes to the tasklist as well as the output file.
     * Gives Exception when the command type is wrong or required content is missed.
     * @param tasks
     * @param ui
     * @param storage
     */
    public void execute(Tasklist tasks,Ui ui,Storage storage) {
        if (Type.equals("list")) {
            ListCommand listcommand = new ListCommand(Type, content);
            listcommand.executecomment(tasks);
        } else if (Type.equals("bye")) {
            ui.sayGoodbye();
        } else if (Type.equals("find")) {
            FindCommand findcommand = new FindCommand(Type, content);
            findcommand.execute(tasks);
        } else if (Type.equals("done")) {
            DoneCommand donecommand = new DoneCommand(Type, content);
            donecommand.execute(tasks, storage);
        } else if (Type.equals("delete")) {
            DeleteCommand deletecommand = new DeleteCommand(Type, content);
            deletecommand.execute(tasks, storage);
        } else if (Type.equals("deadline")) {
            AddCommand add = new AddCommand(Type, content);
            add.addDeadline(tasks, storage);
        } else if (Type.equals("event")) {
            AddCommand add = new AddCommand(Type, content);
            add.addEvent(tasks, storage);
        } else if (Type.equals("todo")) {
            AddCommand add = new AddCommand(Type, content);
            add.addTodo(tasks, storage);
        } else {
            try {
                throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
            } catch (DukeException ex) {
                String temp = "☹ ";
                System.out.println(temp + ex.getMessage());
            }
        }
    }

    /**
     * isExit function checks if the user has typed in "bye" command, is so, exit the programme.
     * @return boolean value of true or false
     */
    public boolean isExit(){
        return Type.equals("bye") ? true : false;
    }

}
