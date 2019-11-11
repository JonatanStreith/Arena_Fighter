package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharaTest {

    @Test
    public void ConstTest(){


        String name = "Steve";
        int attack = 5;
        int defense = 3;


        Chara steve = new Chara(name, attack, defense);

        assertEquals(steve.getName(), "Steve");
        assertEquals(steve.getHealth(), 50);
        assertEquals(steve.getAttack(), 5);
        assertEquals(steve.getDefense(), 3);

    }

    @Test
    public void VillainConstTest() {



        Chara villain = new Chara();


        assertEquals(villain.getName(), "Villain");
        assertEquals(villain.getHealth(), 50);
        assertTrue(villain.getDefense()>0 && villain.getDefense()<6);
        assertTrue(villain.getDefense()>0 && villain.getDefense()<6);


    }
}