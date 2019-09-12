import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void TestDeadline(){
        Deadline temp = new Deadline("return book","Sunday","D");
        assertEquals(temp.toString(),"  [D]" + "["+temp.getStatusIcon()+"]"+"return book"+ " (by:" + "Sunday" + ")");
    }

}