/**
 * Task class stores information of task user wants to add, prints out its completeness in icon form
 * provides method of converting task information to string to print in console.
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected String Type;
    protected String time;

    /**
     * Task constructor method takes in three types of string(type of the task,content of task and
     * ending time of the task from user-input, stores its completeness.
     * @param description
     * @param time
     * @param Type
     */
    public Task(String description,String time,String Type) {
        this.description = description;
        this.time = time;
        this.Type = Type;
        this.isDone = false;
    }

    /**
     * getStatusIcon prints out the status of completeness in icon form.
     * @return icon of tick or cross.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * toString prints out the content of the task.
     * @return the content information of the task.
     */
    public String toString() {
        return description;
    }

    /**
     * markAsDone changes the status of completeness into completed.
     */
    public void markAsDone(){
        this.isDone = true;
    }
}


