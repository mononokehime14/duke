/**
 * The command class provide basic features of commands, storing them by type and content and then execute function
 */
public class Command {
    public String Type;
    public String content;
    public Command(String Type, String content){
        this.Type = Type;
        this.content = content;
    }
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

    public boolean isExit(){
        return Type.equals("bye") ? true : false;
    }

}
