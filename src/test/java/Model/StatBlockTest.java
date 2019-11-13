package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class StatBlockTest {


    @Test
    public void NewStatBlockTest() {

        String profession = "fighter";
        int strength = 6;
        int dexterity = 4;
        int constitution = 4;
        int wisdom = 2;

        StatBlock test = new StatBlock(profession, strength, dexterity, constitution, wisdom);

        //The resultant statblock should contain the supplied values.
        assertEquals(profession, test.getProfession());
        assertEquals(strength, test.getStrength());
        assertEquals(dexterity, test.getDexterity());
        assertEquals(constitution, test.getConstitution());
        assertEquals(wisdom, test.getWisdom());


    }


    @Test
    public void StatBlockCommonerTest() {

        StatBlock test2 = new StatBlock();


        //If no profession or stats are specified, we get a "commoner" statblock with random stats between 1 and 5.
        assertEquals("commoner", test2.getProfession());
        assertTrue(test2.getStrength()> 0&& test2.getStrength() < 6);
        assertTrue(test2.getDexterity()> 0&& test2.getDexterity() < 6);
        assertTrue(test2.getConstitution()> 0&& test2.getConstitution() < 6);
        assertTrue(test2.getWisdom()> 0&& test2.getWisdom() < 6);


    }
}
