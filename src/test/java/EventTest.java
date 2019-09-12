import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void TestEvent(){
        Event temp = new Event("return book","Sunday","E");
        assertEquals(temp.toString(),"  [E]" + "["+temp.getStatusIcon()+"]"+"return book"+ " (at:" + "Sunday" + ")");
    }

}