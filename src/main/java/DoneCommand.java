/**
 * DoneCommand class inherit from Command class.
 * It deals with markdone command, mark the task of corresponding index in the tasklist as completed.
 */
public class DoneCommand extends Command{
    /**
     * DoneCommand constructor function takes two string of the user-input.
     * Store two types of information(type and content)in the DeleteCommand class.
     * @param Type
     * @param content
     */
    public DoneCommand(String Type,String content){
        super(Type,content);
    }

    /**
     * The execute function go through the tasklist, find the task that is done and mark it as accomplished.
     * Reflect the changes in the output file. Print our mark-done message.
     * @param tasks
     * @param storage
     */
    public void execute(Tasklist tasks,Storage storage){
        String[] splitcontent = content.split(" ");
        System.out.println("Nice! I've marked this task as done: ");
        //System.out.println(splitcontent[1]);
        for(int i =0 ;i<tasks.datalist.size();i++){
            if(i + 1== Integer.parseInt(splitcontent[1])){
                tasks.datalist.get(i).markAsDone();
                System.out.println(tasks.datalist.get(i).toString());
            }
        }
        storage.save(tasks);
    }
}