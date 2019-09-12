/**
 * Tasklist class contains a arraylist that will be used to store tasks.
 */

import java.util.ArrayList;

public class Tasklist {
    protected ArrayList<Task> datalist;
    public Tasklist(){
        this.datalist = new ArrayList<Task>();
    }

    /**
     * Tasklist constructor method takes in arraylist read from the txt file, stores it in the class.
     * @param datalist
     */
    public Tasklist(ArrayList<Task> datalist){
        this.datalist = datalist;
    }
}
