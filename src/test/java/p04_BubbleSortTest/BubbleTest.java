package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    int[] numberIsRandomOrder = {5,6,1,2,3,4};
    int[] numberIsCorrectOrder = {1,2,3,4,5,6};

    @Test
    public void testBubbleSort(){
        Bubble.sort(numberIsRandomOrder);


        assertArrayEquals(numberIsRandomOrder,numberIsCorrectOrder);
    }


}