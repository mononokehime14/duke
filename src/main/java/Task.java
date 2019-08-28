public class Task {
    protected String description;
    protected boolean isDone;
    protected String Type;
    protected String time;

    public Task(String description,String time,String Type) {
        this.description = description;
        this.time = time;
        this.Type = Type;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public String toString() {
        return description;
    }
    public void markAsDone(){
        this.isDone = true;
    }
}


