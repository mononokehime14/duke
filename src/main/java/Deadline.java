public class Deadline extends Task {
//    protected String time;
//    protected String Type;
    protected boolean isDone;

    public Deadline(String description,String time,String Type) {
        super(description,time,Type);

        this.isDone = false;
    }

    public String toString() {
        return "  [D]" + "["+super.getStatusIcon()+"]"+super.toString()+ " (by:" + time + ")" ;
    }
}
