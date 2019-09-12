/**
 * Event class inherit from Task class. Stores necessary information of event task.
 */
public class Event extends Task {
//    protected String time;
//    protected String Type;
    protected boolean isDone;

    /**
     * Event constructor method takes in three types of string form user-input.
     * Store information of event task's type, content, time of ends, whether is done.
     * @param description
     * @param time
     * @param Type
     */
    public Event(String description,String time,String Type) {
        super(description,time,Type);
        this.time = time;
        this.Type = Type;
        this.isDone = false;
    }

    /**
     * toSting function convert event class into verbal string.
     * @return String of event information that can be printed out.
     */
    public String toString() {
        return "  [E]" + "["+super.getStatusIcon()+"]"+super.toString()+ " (at:" + time + ")" ;
    }
}
