public class DoneCommand extends Command{
    public DoneCommand(String Type,String content){
        super(Type,content);
    }
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