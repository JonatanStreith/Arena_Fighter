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

//    @Test
//    public void VillainConstTest() {
//
//
//
//        Chara villain = new Chara();
//
//
//        assertEquals(villain.getName(), "Villain");
//        assertEquals(villain.getHealth(), 50);
//        assertTrue(villain.getStats().getConstitution()>0 && villain.getStats().getConstitution()<6);
//        assertTrue(villain.getStats().getStrength()>0 && villain.getStats().getStrength()<6);
//
//
//    }


    @Test
    public void getMatchingLevelTest() {


        //Result should be within a deviation of 3 from original number

            int result = Chara.getMatchingLevel(5);


        assertEquals(5, result, 3);


    }
}
