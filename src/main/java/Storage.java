import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileReader;

public class Storage {
    String filepath;

    public Storage(String filepath){
        this.filepath = filepath;
    }

    public ArrayList<Task> load(){
        ArrayList<Task> temp = new ArrayList<Task>();
        File checkfile = new File(filepath);
        if(checkfile.exists()){
            try (Scanner s = new Scanner(new FileReader(filepath))) {
                while (s.hasNext()) {
                    String content = s.nextLine();
                    String[] tempsplit = content.split("/");
                    String description = tempsplit[2];
                    String time = tempsplit[0].equals("T") ? "" : tempsplit[3];
                    String Type = tempsplit[0];
                    if(Type.equals("T")) {
                        Task t = new Todo(description, time, Type);
                        if (tempsplit[1].equals("done")) {
                            t.markAsDone();
                        }
                        temp.add(t);
                    }else if(Type.equals("D")){
                        Task t = new Deadline(description, time, Type);
                        if (tempsplit[1].equals("done")) {
                            t.markAsDone();
                        }
                        temp.add(t);
                    }else{
                        Task t = new Event(description, time, Type);
                        if (tempsplit[1].equals("done")) {
                            t.markAsDone();
                        }
                        temp.add(t);
                    }
                }
            }catch(Exception e){System.out.println(e);}
        }else {
            File file = new File(filepath);
            try {
                if (file.createNewFile()) {
                    System.out.println("File is created!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return temp;
    }
    public void save(Tasklist tasks){
        try {
            FileOutputStream outputStream = new FileOutputStream(filepath);
            for (int i = 0; i < tasks.datalist.size(); i++) {
                String tempdone = tasks.datalist.get(i).isDone ? "done" : "notdone";
                String outputline = tasks.datalist.get(i).Type + "/" + tempdone + "/" + tasks.datalist.get(i).description + "/" + tasks.datalist.get(i).time;
                byte[] strToBytes = outputline.getBytes();
                outputStream.write(strToBytes);
                outputStream.write('\n');
            }
            outputStream.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void add(String outputline){
        try{
            FileOutputStream outputStream = new FileOutputStream(filepath, true);
            byte[] strToBytes = outputline.getBytes();
            outputStream.write(strToBytes);
            outputStream.write('\n');
            outputStream.close();
        }catch(Exception e){System.out.println(e);}
    }
}
