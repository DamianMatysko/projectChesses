import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodsTest {
    Methods methods = new Methods();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void normalize() {
        assertNull(methods.normalize(null));
        assertNull(methods.normalize("C18"));
        assertNull(methods.normalize("AF"));
        assertNull(methods.normalize("T5"));

        assertEquals("D4",methods.normalize("D4"));
        assertEquals("A3",methods.normalize("A3"));
        assertEquals("A8",methods.normalize("8a"));
        assertEquals("H6",methods.normalize("6h"));
    }

    @Test
    public void checkBishop() {
        assertTrue(methods.checkBishop("A1","B2"));
        assertTrue(methods.checkBishop("A1","G7"));


        assertTrue(methods.checkBishop("D4","A1"));
        assertTrue(methods.checkBishop("D4","B2"));
        assertTrue(methods.checkBishop("D4","C3"));
        assertTrue(methods.checkBishop("D4","E5"));
        assertTrue(methods.checkBishop("D4","F6"));
        assertTrue(methods.checkBishop("D4","G7"));
        assertTrue(methods.checkBishop("D4","H8"));
        assertTrue(methods.checkBishop("D4",""));
        assertTrue(methods.checkBishop("D4",""));
        assertTrue(methods.checkBishop("D4",""));



        assertFalse(methods.checkBishop("A1","H2"));
        assertFalse(methods.checkBishop("4D","4D"));
    }

    @Test
    public void checkQueen() {
    }

    @Test
    public void checkKing() {
        assertTrue(methods.checkKing("A1","A2"));
        assertTrue(methods.checkKing("a1","a2"));
        assertTrue(methods.checkKing("1A","2A"));
        assertTrue(methods.checkKing("1a","2a"));

        assertTrue(methods.checkKing("B2","B1"));
        assertTrue(methods.checkKing("B2","B3"));
        assertTrue(methods.checkKing("B2","A2"));
        assertTrue(methods.checkKing("B2","C2"));
        assertTrue(methods.checkKing("B2","A1"));
        assertTrue(methods.checkKing("B2","C3"));
        assertTrue(methods.checkKing("B2","A3"));
        assertTrue(methods.checkKing("B2","C1"));

        assertFalse(methods.checkKing("A1","H2"));
        assertFalse(methods.checkKing("A1","a1"));
        assertFalse(methods.checkKing("A1","a6"));
        assertFalse(methods.checkKing("AA1","H2"));
    }

    @Test
    public void possibleMovementsKnight() {
    }

    @Test
    public void checkKnight() {
    }

    @Test
    public void checkRook() {
    }

    @Test
    public void checkPawn() {
    }
}