package Model;

import org.junit.Test;

import static org.junit.Assert.*;


public class BattleTest {

    @Test
    public void constructorTestAndDetermineOutcomeTest() {      //Testing both methods as one, because they work together

        Chara player = new Chara(1);
        Chara opponent = new Chara(1);


        Battle battle = new Battle(player, opponent);   //We create two random participants and have them fight it out

        String outcome = battle.getOutcome();

        assertNotNull(battle);
        assertNotNull(battle.getBattleLog());
        assertNotEquals(0, battle.getRoundsPassed());   //Make sure at least one round happened
        assertTrue((outcome.equals("victory")) || (outcome.equals("defeat")) || (outcome.equals("doubledefeat")));


    }

}
