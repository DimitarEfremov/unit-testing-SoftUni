package TestDrivenDevelopment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstockTest {
    Instock instock;
    Product product1;
    Product product2;
    Product product3;


    @Before
    public void prepare(){
        instock = new Instock();
        product1 = new Product("Test1", 1, 1);
        product2 = new Product("Test2", 1, 1);
        product3 = new Product("Test3", 1, 1);

    }


    @Test
    public void testAddAddsCorrectly(){
        instock.add(product1);
        assertTrue(instock.contains(product1));
        assertFalse(instock.contains(product2));
    }

    @Test
    public void testGetCountCorrect(){
        assertEquals(0,instock.getCount());
        instock.add(product1);
        assertEquals(1,instock.getCount());
        instock.add(product2);
        assertEquals(2,instock.getCount());
        instock.add(product3);
        assertEquals(3,instock.getCount());
    }

    @Test ()
    public void testFindProductCorrectly(){
        instock.add(product1);
        instock.add(product2);

        assertEquals(product2, instock.find(1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testFindProductThrows(){
        instock.add(product1);
        instock.add(product2);
        instock.find(4);



    }

}