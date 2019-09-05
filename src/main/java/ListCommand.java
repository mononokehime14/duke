

public class ListCommand extends Command{

    public ListCommand(String Type,String content){
        super(Type,content);
        this.Type = Type;
        this.content = content;
    }
    public void executecomment(Tasklist tasks){
        System.out.println("Here are the tasks in your list:");
        for (int i=0;i<tasks.datalist.size();i++){
            String time = tasks.datalist.get(i).toString();
            System.out.println((i+1)+"." + time);
        }
    }
}
