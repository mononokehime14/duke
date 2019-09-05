public class AddCommand extends Command {
    public AddCommand(String Type, String content){
        super(Type,content);
    }
    public void addDeadline(Tasklist tasks, Storage storage){
        String[] splitcontent = content.split(" ");
        try {
            if (splitcontent.length == 0) {
                throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
            } else {
                String description = "";
                String time = "";
                int i = 1;
                while (i < splitcontent.length && splitcontent[i].charAt(0) != '/') {
                    description = description + " " + splitcontent[i];
                    i++;
                }
                i = i + 1;
                boolean flag = false;
                int count = 0;
                for (int j = 0; j < splitcontent[i].length(); j++) {
                    if (splitcontent[i].charAt(j) == '/') {
                        count++;
                    }
                }
                if (count == 2) flag = true;

                while (i < splitcontent.length) {
                    time = time + " " + splitcontent[i];
                    i++;
                }
                if(flag){
                    String[] temptime = time.split(" ");
                    String[] tempdate = temptime[1].split("/");
                    Date x = new Date(tempdate[0],tempdate[1],tempdate[2],temptime[2]);
                    time = x.toString();
                }
                System.out.println("Got it. I've added this task:");
                Task t = new Deadline(description, time, "D");
                tasks.datalist.add(t);
                String outputline = "D/"+"notdone/"+ description + "/"+time;
                storage.save(tasks);
                System.out.println(t.toString());
                System.out.println("Now you have " + tasks.datalist.size() + " tasks in the list.");
            }
        }catch (DukeException ex){
            String temp = "☹ ";
            System.out.println(temp + ex.getMessage());
        }
    }
    public void addEvent(Tasklist tasks, Storage storage){
        String[] splitcontent = content.split(" ");
        try {
            if (splitcontent.length == 0) {
                throw new DukeException("OOPS!!! The description of a event cannot be empty.");
            } else {
                String description = "";
                String time = "";
                int i = 1;
                while (i < splitcontent.length && splitcontent[i].charAt(0) != '/') {
                    description = description + " " + splitcontent[i];
                    i++;
                }
                i = i + 1;
                boolean flag = false;
                int count = 0;
                for (int j = 0; j < splitcontent[i].length(); j++) {
                    if (splitcontent[i].charAt(j) == '/') {
                        count++;
                    }
                }
                if (count == 2) flag = true;

                while (i < splitcontent.length) {
                    time = time + " " + splitcontent[i];
                    i++;
                }
                if(flag){
                    String[] temptime = time.split(" ");
                    String[] tempdate = temptime[1].split("/");
                    Date x = new Date(tempdate[0],tempdate[1],tempdate[2],temptime[2]);
                    time = x.toString();
                }
                System.out.println("Got it. I've added this task:");
                Task t = new Event(description, time, "E");
                tasks.datalist.add(t);
                String outputline = "E/"+"notdone/"+ description + "/"+time;
                storage.add(outputline);
                System.out.println(t.toString());
                System.out.println("Now you have " + tasks.datalist.size() + " tasks in the list.");

            }
        }catch (DukeException ex){
            String temp = "☹ ";
            System.out.println(temp + ex.getMessage());
        }
    }
    public void addTodo(Tasklist tasks, Storage storage){
        String[] splitcontent = content.split(" ");
        try {
            if (splitcontent.length == 0) {
                throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
            }else {

                String description = "";
                String time = "";
                int i = 0;
                while (i < splitcontent.length) {
                    description = description + " " + splitcontent[i];
                    i++;
                }
                System.out.println("Got it. I've added this task:");
                Task t = new Todo(description, time, "T");
                tasks.datalist.add(t);
                String outputline = "T/"+"notdone/"+ description + "/"+time;;
                System.out.println(t.toString());
                storage.add(outputline);

                System.out.println("Now you have " + tasks.datalist.size() + " tasks in the list.");
            }
        }catch (DukeException ex){
            String temp = "☹ ";
            System.out.println(temp + ex.getMessage());
        }
    }
}
