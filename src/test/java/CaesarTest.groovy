package Caesar
import junit.framework.TestCase
import org.junit.Test

public class CaesarTest extends TestCase {

    @Test
    public void testtheMessage_shouldBeGrab_String(){
        Caesar caesar= new Caesar("Grab", 2);
        assertEquals("Grab", caesar.getMessage());
    }

    @Test
    public void testEncryptDecrypt_ShiftValueSaved_Integer() {
        Caesar caesar = new Caesar("jumbo", 3);
        assertEquals(3, caesar.getShift());
    }
    @Test
    public void testEncryptDecrypt_objectInstantiates() {
        Caesar caesar = new Caesar("Tesla", 3);
        assertEquals(true, caesar instanceof Caesar);

    }
}