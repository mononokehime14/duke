import java.util.ArrayList;

public class FindCommand extends Command{
    public FindCommand(String Type,String content){
        super(Type,content);
    }
    public void execute(Tasklist tasks){
        String[] splitcontent = content.split(" ");
        String keyword = splitcontent[1];
        ArrayList<Task> searchlist = new ArrayList<Task>();
        for(int i=0;i<tasks.datalist.size();i++){
            String tempdescription[] = tasks.datalist.get(i).description.split(" ");
            boolean tempflag = true;
            for(int j=0;j<tempdescription.length && tempflag;j++){
                if(tempdescription[j].equals(keyword)){
                    searchlist.add(tasks.datalist.get(i));
                    tempflag = false;
                }
            }
        }
        System.out.println("Here are the matching tasks in your list:");
        for (int i=0;i<searchlist.size();i++){
            String time = searchlist.get(i).toString();
            System.out.println((i+1)+"." + time);
        }
        searchlist.clear();
    }
}
