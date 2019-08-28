public class Todo extends Task {
//    protected String time;
//    protected String Type;
    protected boolean isDone;

    public Todo(String description,String time,String Type) {
        super(description,time,Type);
        this.time = time;
        this.Type = Type;
        this.isDone = false;
    }

    public String toString() {
        return "  [T]" + "["+super.getStatusIcon()+"]"+super.toString();
    }
}