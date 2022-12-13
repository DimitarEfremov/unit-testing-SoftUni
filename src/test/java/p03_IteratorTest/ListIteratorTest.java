package p03_IteratorTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] WORDS = {"az", "bobo", "vova", "gogo"};


    @Before
    public  void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator(WORDS);
    }


    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNull() throws OperationNotSupportedException {
        ListIterator nullListIterator = new ListIterator(null);
    }

    @Test
    public void testSuccessfulConstructor() throws OperationNotSupportedException {

        ListIterator correctListIterator = new ListIterator(WORDS);

    }

    @Test
    public void testHasNext(){
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());

    }

    @Test
    public void testMove(){
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test (expected = IllegalStateException.class)
    public void testShouldThrowWithEmptyIterator() throws OperationNotSupportedException {
        ListIterator blankIterator = new ListIterator();

        blankIterator.print();

    }

    @Test
    public void testPrintSuccess(){
        assertEquals(WORDS[0], listIterator.print());
        listIterator.move();
        assertEquals(WORDS[1], listIterator.print());


    }
}