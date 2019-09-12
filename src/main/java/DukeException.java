/**
 * DukeException class is a custom Exception class that inherit from the java Exception class.
 * It shows custom warnings when custom exceptions happen.
 */
public class DukeException extends Exception {
    public DukeException(){}

    /**
     * DukeException constructor method takes in the message that wants to display.
     * @param message
     */
    public DukeException(String message){
        super(message);
    }
}
