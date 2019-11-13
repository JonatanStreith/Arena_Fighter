package Model;

import org.junit.Test;


import static org.junit.Assert.*;

public class RoundTest {

    @Test
    public void constructorTest() {

        Chara player = new Chara(1);
        Chara opponent = new Chara(1);

        Round newRound = new Round(player, opponent);


        //Too many random outcomes to really test for specific outcomes!
        //All we can look for is that dicerolls are within correct ranges, and that we get an outcome message.
        //(If we don't get an outcome message, something will have gone wrong before that!)

        assertNotNull(newRound);
        assertTrue(newRound.getPlayerDice() >= 1 && newRound.getPlayerDice() <= 6);
        assertTrue(newRound.getOpponentDice() >= 1 && newRound.getOpponentDice() <= 6);
        assertNotEquals("", newRound.getRoundMessage());


    }


}
