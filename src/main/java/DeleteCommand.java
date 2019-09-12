/**
 * DeleteCommand class inherit from command class, store the delete command.
 * It accomplishes actual deleting on the tasklist as well as inside the output file.
 */
public class DeleteCommand extends Command{
    /**
     * DeleteCommand constructor function takes in two strings from the user-input, store information of type and content in the command class.
     * @param Type
     * @param content
     */
    public DeleteCommand(String Type,String content){
        super(Type,content);
    }

    /**
     * execute function removes a task in the tasklist as well as in the output file in storage.
     * displays the deleted message.
     * @param tasks
     * @param storage
     */
    public void execute(Tasklist tasks,Storage storage){
        int removeindex=0;
        String[] splitcontent = content.split(" ");
        System.out.println("Noted. I've removed this task: ");
        for(int i =0 ;i<tasks.datalist.size();i++){
            if(i + 1== Integer.parseInt(splitcontent[1])){
                removeindex = i;
                System.out.println(tasks.datalist.get(i).toString());
            }
        }
        boolean loopflag = true;
        for(int i =0 ;i<tasks.datalist.size() && loopflag;i++){
            if(removeindex == i){
                loopflag = false;
                tasks.datalist.remove(removeindex);
            }
        }
        System.out.println("Now you have "+tasks.datalist.size()+" tasks in the list.");
        storage.save(tasks);
    }
}

