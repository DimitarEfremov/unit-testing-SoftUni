package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int ATTACK = 10;
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 10;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(0, EXPERIENCE);
    }

    @Test
    public void testDummyIfHealthIsReducedAfterAttack(){

        dummy.takeAttack(ATTACK);
        int expectedResult = HEALTH - ATTACK;
        assertEquals(expectedResult,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)

    public void testDummyIfThrowsExceptionWhenDead(){
        deadDummy.takeAttack(ATTACK);
    }

    @Test
    public void testDummyGivesXPWhenDead(){
        assertEquals(EXPERIENCE,deadDummy.giveExperience());
    }

    @Test (expected = IllegalStateException.class)
    public void testDummyIfThrowsExceptionWhenTryToGiveExperienceWhenDead(){
        dummy.giveExperience();
    }

}