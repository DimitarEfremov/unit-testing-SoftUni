package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database validDatabase;
    private Database blankDatabase;
    private Person ahmed = new Person(1, "Ahmed");
    private Person bobo = new Person(2, "Bobo");
    private Person vova = new Person(3, "Vova");

    @Before

    public void prepare() throws OperationNotSupportedException {

        validDatabase = new Database(ahmed,bobo,vova);
    }

    @Test
    public void testFindByUsernameWithCorrectName() throws OperationNotSupportedException {

        Person person = validDatabase.findByUsername("Ahmed");

        assertEquals(person.getUsername(), ahmed.getUsername());
        assertEquals(person.getId(),ahmed.getId());


    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExceptionWithNull() throws OperationNotSupportedException {

        Person person = validDatabase.findByUsername(null);

    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExceptionWithWrongName() throws OperationNotSupportedException {

        Person person = validDatabase.findByUsername("Gogo");

    }

}