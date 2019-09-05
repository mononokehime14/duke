public class Parser {
    public Command command;
    protected String Type;
    protected String content;
    public String parseType(String userinput){
        String[] splitstring = userinput.split(" ");
        Type = splitstring[0];
        return Type;
    }
    public String parseContent(String userinput){
        String Type= "";
        String content = "";
        String[] splitstring = userinput.split(" ");
        Type = splitstring[0];
        int i = 1;
        while(i <  splitstring.length){
            content += " "+splitstring[i];
            i++;
        }
        return content;
    }
}
