/**
 * ListCommand inherit from the Command class, stores type of the command and displays the whole current tasklist
 * in the console.
 */

public class ListCommand extends Command{
    /**
     * ListCommand constructor method takes in type and the content(usually empty)of the command
     * @param Type
     * @param content
     */
    public ListCommand(String Type,String content){
        super(Type,content);
        this.Type = Type;
        this.content = content;
    }

    /**
     * executecomment method displays/prints out the current tasklist in the console.
     * @param tasks
     */
    public void executecomment(Tasklist tasks){
        System.out.println("Here are the tasks in your list:");
        for (int i=0;i<tasks.datalist.size();i++){
            String time = tasks.datalist.get(i).toString();
            System.out.println((i+1)+"." + time);
        }
    }
}
