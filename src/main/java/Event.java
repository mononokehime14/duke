public class Event extends Task {
//    protected String time;
//    protected String Type;
    protected boolean isDone;

    public Event(String description,String time,String Type) {
        super(description,time,Type);
        this.time = time;
        this.Type = Type;
        this.isDone = false;
    }

    public String toString() {
        return "  [E]" + "["+super.getStatusIcon()+"]"+super.toString()+ " (at:" + time + ")" ;
    }
}
