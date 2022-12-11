package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class HeroTest {

    @Test
    public void testHeroAttackWhenTargetIsKilledHeroGetsXP(){

        Target mockTarget = mock(Target.class);
        Weapon mockWeapon = mock(Weapon.class);

        int exp = 10;
        when(mockTarget.isDead()).thenReturn(true);
        when(mockTarget.giveExperience()).thenReturn(exp);

        Hero hero = new Hero("batMitko", mockWeapon);


        hero.attack(mockTarget);
        Assert.assertEquals(exp, hero.getExperience());


    }

}