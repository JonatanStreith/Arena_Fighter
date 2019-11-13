package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharaTest {

//    @Test
//    public void ConstTest(){
//
//
//        String name = "Steve";
//        int attack = 5;
//        int defense = 3;
//
//
//        Chara steve = new Chara(name, 1, 5, 4, 3, 2);
//
//        assertEquals(steve.getName(), "Steve");
//        assertEquals(steve.getHealth(), 50);
//        assertEquals(steve.getStats().getStrength(), 5);
//        assertEquals(steve.getStats().getConstitution(), 3);
//
//    }

    @Test
    public void VillainConstTest() {



        Chara villain = new Chara(1);


        assertNotNull(villain.getName());
        assertTrue(villain.getHealth() > 20);
        assertNotNull(villain.getStats());
        assertNotNull(villain.getInventory());


    }


    @Test
    public void getMatchingLevelTest() {


        //Result should be within a deviation of 3 from original number

            int result = Chara.getMatchingLevel(5);


        assertEquals(5, result, 3);


    }
}
