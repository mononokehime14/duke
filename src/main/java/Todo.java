/**
 * Todo class inherit from the Task class, store and print out todo task.
 */
public class Todo extends Task {
//    protected String time;
//    protected String Type;
    protected boolean isDone;

    /**
     *Todo constructor method takes in three types of string(type of the task,content of task and
     * ending time of the task from user-input, stores its completeness.
     * @param description
     * @param time
     * @param Type
     */
    public Todo(String description,String time,String Type) {
        super(description,time,Type);
        this.time = time;
        this.Type = Type;
        this.isDone = false;
    }
    /**
     * toString convert the information fo todo task into written form.
     * @return String of todo task that can be printed our in console.
     */
    public String toString() {
        return "  [T]" + "["+super.getStatusIcon()+"]"+super.toString();
    }
}