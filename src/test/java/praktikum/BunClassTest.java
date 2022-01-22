package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunClassTest {

    @Test
    public void getNameMethodWorks(){
        Bun testBun = new Bun("TestBun", 300);
        assertEquals("TestBun", testBun.getName());
    }

    @Test
    public void getPriceMethodWorks(){
        Bun testBun = new Bun("TestBun", 222);
        assertEquals(222, testBun.getPrice(),0.01);
    }
}
