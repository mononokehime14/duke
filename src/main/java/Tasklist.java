import java.util.ArrayList;

public class Tasklist {
    protected ArrayList<Task> datalist;
    public Tasklist(){
        this.datalist = new ArrayList<Task>();
    }
    public Tasklist(ArrayList<Task> datalist){
        this.datalist = datalist;
    }
}
