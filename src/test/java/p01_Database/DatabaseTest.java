package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database validDatabase;
    private final Integer[] VALID_NUMBERS_1_to_6 = {1,2,3,4,5,6};

    @Before
    public void Prepare() throws OperationNotSupportedException {
        validDatabase = new Database(VALID_NUMBERS_1_to_6);

    }

    @Test
    public void testConstructorCreatesValidDataBase() throws OperationNotSupportedException {
        Integer[] dbElements = validDatabase.getElements();
        assertArrayEquals(VALID_NUMBERS_1_to_6, dbElements);

    }

    @Test(expected = OperationNotSupportedException.class )
    public void testConstructorThrowExceptionMoreThan16Elements() throws OperationNotSupportedException {

        Integer[] testDataForCreation = {1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6};

        Database database = new Database(testDataForCreation);

    }

    @Test(expected = OperationNotSupportedException.class )
    public void testConstructorThrowExceptionLessThanOneElements() throws OperationNotSupportedException {

        Integer[] testDataForCreation = {};

        Database database = new Database(testDataForCreation);

    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddWithNullThatThrowException() throws OperationNotSupportedException {
            validDatabase.add(null);

    }

    @Test

    public void testAddValidNumber() throws OperationNotSupportedException {
        validDatabase.add(11);
        Integer[] dbElements = validDatabase.getElements();
        assertEquals(Integer.valueOf(11),dbElements[dbElements.length-1]);
        assertEquals(VALID_NUMBERS_1_to_6.length+1,validDatabase.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDBThrowsException() throws OperationNotSupportedException {
        Database database = new Database(1);
        database.remove();
        database.remove();
    }

    @Test
    public void testRemoveSuccess() throws OperationNotSupportedException {
        validDatabase.remove();
        Integer[] dbElements = validDatabase.getElements();

        Integer lastElementAfterRemove = dbElements[dbElements.length-1];
        Integer nextToTheLastElementBeforeRemove = VALID_NUMBERS_1_to_6[VALID_NUMBERS_1_to_6.length - 2];

        assertEquals(nextToTheLastElementBeforeRemove, lastElementAfterRemove);
                ;
        assertEquals(VALID_NUMBERS_1_to_6.length-1,validDatabase.getElements().length);


    }

}