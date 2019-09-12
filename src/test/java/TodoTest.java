import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void TestTodo(){
        Todo temp = new Todo("return book","","T");
        assertEquals(temp.toString(),"  [T]" + "["+temp.getStatusIcon()+"]"+"return book");
    }

}
