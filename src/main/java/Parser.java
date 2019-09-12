/**
 * Parser class deals with user-input, split and recognize type of user-input,
 * makes user-input readable and useful.
 */
public class Parser {
    public Command command;
    protected String Type;
    protected String content;

    /**
     * parseType method takes in the whole string of user-input, split it by blank" ",
     * And then store the first element of string list as type of the command.
     * @param userinput
     * @return
     */
    public String parseType(String userinput){
        String[] splitstring = userinput.split(" ");
        Type = splitstring[0];
        return Type;
    }

    /**
     * parseContent method takes in the whole string of user-input, split it by blank" ",
     * And then store the rest elements except the first element of string list as content of the command.
     * @param userinput
     * @return
     */
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
