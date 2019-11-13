package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharaTest {

    @Test
    public void ConstTest(){


        String name = "Steve";
        String profession = "assassin";
        int strength = 4;
        int dexterity = 5;
        int constitution = 3;
        int wisdom = 4;

        StatBlock stevesStats = new StatBlock(profession, strength, dexterity, constitution, wisdom);

        Chara steve = new Chara(name, 1, stevesStats);

        assertEquals("Steve", steve.getName());
        assertEquals(35, steve.getHealth());
        assertEquals("assassin", steve.getStats().getProfession());
        assertEquals(4, steve.getStats().getStrength());
        assertEquals(5, steve.getStats().getDexterity());
        assertEquals(3, steve.getStats().getConstitution());
        assertEquals(4, steve.getStats().getWisdom());


    }

    @Test
    public void VillainConstTest() {



        Chara villain = new Chara(1);


        assertNotNull(villain.getName());
        assertTrue(villain.getHealth() > 20);
        assertNotNull(villain.getStats());
        assertNotNull(villain.getInventory());


    }

    @Test
    public void getVillainNameTest() {

        String test = Chara.getVillainName();

        assertNotNull(test);    //It's not null
        assertNotEquals("", test); //It's not blank
    }


    @Test
    public void getMatchingLevelTest() {


        //Result should be within a deviation of 3 from original number

            int result = Chara.getMatchingLevel(5);


        assertEquals(5, result, 3);


    }




    @Test
    public void getRandomProfessionTest() {

        String randomprof = Chara.getRandomProfession();

        assertNotEquals("", randomprof);


    }

    @Test
    public void getStatsTest() {

        StatBlock testStats = Chara.getStats("F");  //Should get stats for a fighter

        assertNotNull(testStats);
        assertEquals("fighter", testStats.getProfession());
        assertEquals(6, testStats.getStrength());   //Fighter have strength 6, so...

        StatBlock randomStats = Chara.getStats("5");    //Invalid inputs should get the class "commoner"

        assertNotNull(randomStats);
        assertEquals("commoner", randomStats.getProfession());

    }

    @Test
    public void createPlayerCharacterTest() {

        //Cannot test method that requires input?

    }

    @Test
    public void levelUpTest() {

        Chara testCase = new Chara("Dave", 1, new StatBlock("barbarian", 1,1,1,1)); //Our test case

        assertTrue(testCase.getLevel() == 1); //Assert that he is level 1

        testCase.levelUp();

        assertTrue(testCase.getLevel() == 2); //Assert that he is level 1

    }

    @Test
    public void reduceHealthByTest() {

        Chara testCase = new Chara("Dave", 1, new StatBlock("barbarian", 1,1,1,1)); //Our test case

        int startingHealth = testCase.getHealth();  //Get the health before taking damage, to compare with

        testCase.reduceHealthBy(10);

        assertEquals(startingHealth-10, testCase.getHealth());

    }

    @Test
    public void getRandomLootTest() {

        //Cannot test method that requires input

    }

    @Test
    public void claimLootTest() {

        //Cannot test method that requires input

    }

    @Test
    public void victoryTest() {

        //Cannot test method that requires input

    }


}
