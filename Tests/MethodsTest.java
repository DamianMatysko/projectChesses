import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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

        assertFalse(methods.checkBishop("A1","H2"));
        assertFalse(methods.checkBishop("4D","4D"));
        assertFalse(methods.checkBishop("4D","4e"));
        assertFalse(methods.checkBishop("4D","4c"));
        assertFalse(methods.checkBishop("4D","3D"));
        assertFalse(methods.checkBishop("4D","2D"));
    }

    @Test
    public void checkQueen() {
        assertTrue(methods.checkQueen("B2","B3"));
        assertTrue(methods.checkQueen("B2","B3"));
        assertTrue(methods.checkQueen("B2","B4"));
        assertTrue(methods.checkQueen("B2","B5"));
        assertTrue(methods.checkQueen("B2","B6"));
        assertTrue(methods.checkQueen("B2","B7"));
        assertTrue(methods.checkQueen("B2","B8"));
        assertTrue(methods.checkQueen("B2","B1"));

        assertTrue(methods.checkQueen("B2","a2"));
        assertTrue(methods.checkQueen("B2","c2"));
        assertTrue(methods.checkQueen("B2","e2"));
        assertTrue(methods.checkQueen("B2","g2"));

        assertTrue(methods.checkQueen("B2","c2"));

        assertTrue(methods.checkQueen("A1","B2"));
        assertTrue(methods.checkQueen("A1","G7"));

        assertTrue(methods.checkQueen("D4","A1"));
        assertTrue(methods.checkQueen("D4","B2"));
        assertTrue(methods.checkQueen("D4","C3"));
        assertTrue(methods.checkQueen("D4","E5"));
        assertTrue(methods.checkQueen("D4","F6"));
        assertTrue(methods.checkQueen("D4","G7"));
        assertTrue(methods.checkQueen("D4","H8"));


        assertFalse(methods.checkQueen("E1","H8"));
        assertFalse(methods.checkQueen("1e","8h"));

        assertFalse(methods.checkQueen("1E","a8"));
        assertFalse(methods.checkQueen("1E","b8"));
        assertFalse(methods.checkQueen("1E","c8"));
        assertFalse(methods.checkQueen("1E","d8"));
        assertFalse(methods.checkQueen("1E","f8"));
        assertFalse(methods.checkQueen("1E","g8"));
        assertFalse(methods.checkQueen("1E","c7"));
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
        Set<String> movementsAraund = new HashSet<>();
        movementsAraund.add("D1");
        movementsAraund.add("E2");
        movementsAraund.add("A2");
        movementsAraund.add("B1");
        movementsAraund.add("A4");
        movementsAraund.add("B5");
        movementsAraund.add("E4");
        movementsAraund.add("D5");
        Set<String> movementsA1 = new HashSet<>();
        movementsA1.add("B3");
        movementsA1.add("C2");

        assertEquals(movementsAraund, methods.possibleMovementsKnight("C3"));
        assertEquals(movementsA1, methods.possibleMovementsKnight("A1"));

        assertNotEquals(movementsAraund, methods.possibleMovementsKnight("A1"));
        assertNotEquals(movementsA1, methods.possibleMovementsKnight("A2"));
    }

    @Test
    public void checkKnight() {
        assertTrue(methods.checkKnight("C3","d1"));
        assertTrue(methods.checkKnight("C3","2e"));
        assertTrue(methods.checkKnight("C3","2a"));
        assertTrue(methods.checkKnight("C3","1b"));
        assertTrue(methods.checkKnight("C3","a4"));
        assertTrue(methods.checkKnight("C3","b5"));
        assertTrue(methods.checkKnight("C3","e4"));
        assertTrue(methods.checkKnight("C3","d5"));

        assertFalse(methods.checkKnight("C3","c5"));
        assertFalse(methods.checkKnight("C3","c1"));
        assertFalse(methods.checkKnight("C3","a3"));
        assertFalse(methods.checkKnight("C3","e3"));
        assertFalse(methods.checkKnight("C3","b3"));
        assertFalse(methods.checkKnight("C3","h8"));
        assertFalse(methods.checkKnight("C3","a8"));
    }

    @Test
    public void checkRook() {
        assertTrue(methods.checkRook("B2","B3"));
        assertTrue(methods.checkRook("B2","B3"));
        assertTrue(methods.checkRook("B2","B4"));
        assertTrue(methods.checkRook("B2","B5"));
        assertTrue(methods.checkRook("B2","B6"));
        assertTrue(methods.checkRook("B2","B7"));
        assertTrue(methods.checkRook("B2","B8"));
        assertTrue(methods.checkRook("B2","B1"));

        assertTrue(methods.checkRook("B2","a2"));
        assertTrue(methods.checkRook("B2","c2"));
        assertTrue(methods.checkRook("B2","e2"));
        assertTrue(methods.checkRook("B2","g2"));

        assertTrue(methods.checkRook("B2","c2"));

        assertFalse(methods.checkRook("A1","b2"));
        assertFalse(methods.checkRook("A1","f5"));
        assertFalse(methods.checkRook("A1","9b"));
        assertFalse(methods.checkRook("A1","7c"));
        assertFalse(methods.checkRook("A1","G8"));
    }

    @Test
    public void checkPawn() {
    }
}