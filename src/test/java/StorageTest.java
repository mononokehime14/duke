import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StorageTest {

    @Test
    void TestStorage() {
        String currentpath = System.getProperty("user.dir");
        Storage storage = new Storage(currentpath+"/docs/tasklist.txt");
        Tasklist temp = new Tasklist();
        temp.datalist = storage.load();
        assertTrue(!temp.datalist.isEmpty());
    }
}