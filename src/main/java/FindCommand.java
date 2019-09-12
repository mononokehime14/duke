/**
 * FindCommand  inherit from Command class, store information of find user-command.
 * It accomplishes finding the exact tasks according the keyword user typed in.
 */

import java.util.ArrayList;

public class FindCommand extends Command{
    /**
     * FindCommand constructor method takes in two string from user-input, stores type of the command and also the keyword of searching.
     * @param Type
     * @param content
     */
    public FindCommand(String Type,String content){
        super(Type,content);
    }

    /**
     * execute method search in the tasklist and find all tasks that correspond to the keyword.
     * All results will be printed out in the console.
     * @param tasks
     */
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
