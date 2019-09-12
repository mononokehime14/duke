/**
 * Deadline class inherit from Task class, has boolean value isDone to track the completeness of the task.
 * It also enables convert to string format the are ready to be printed out
 */
public class Deadline extends Task {
//    protected String time;
//    protected String Type;
    protected boolean isDone;

    /**
     * Deadline constructor function takes three strings(content,time,and type) from the user-input,store them in the class.
     * @param description
     * @param time
     * @param Type
     */
    public Deadline(String description,String time,String Type) {
        super(description,time,Type);

        this.isDone = false;
    }

    /**
     * toString function convert the deadline class into string that can be printed out.
     * @return String format of deadline task that are ready to be printed out.
     */
    public String toString() {
        return "  [D]" + "["+super.getStatusIcon()+"]"+super.toString()+ " (by:" + time + ")" ;
    }
}
