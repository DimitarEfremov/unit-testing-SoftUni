package TestDrivenDevExcersise;

import org.junit.Before;
import org.junit.Test;

public class ChainblockImplTest {
    private Chainblock chainblock;
    Transaction transaction1;
    Transaction transaction2;
    Transaction transaction3;
    Transaction transaction4;


    @Before
    private void prepare(){
        transaction1 = new TransactionImpl(11, TransactionStatus.SUCCESSFUL, "Ahmed", "Bobo", 11);
        transaction2 = new TransactionImpl(22, TransactionStatus.SUCCESSFUL, "Gogo", "Bobo", 22);
        transaction3 = new TransactionImpl(33, TransactionStatus.FAILED, "Bobo", "Ahmed", 33);
        transaction4 = new TransactionImpl(44, TransactionStatus.ABORTED, "Ahmed", "Gogo", 44);
        chainblock = new ChainblockImpl();



    }


        @Test
    private void testAddSuccessful(){
            chainblock.add(transaction3);



        }


}