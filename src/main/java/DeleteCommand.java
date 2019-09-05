public class DeleteCommand extends Command{
    public DeleteCommand(String Type,String content){
        super(Type,content);
    }
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

