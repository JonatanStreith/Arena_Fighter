package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void NewInventorySpecificTest() {

        Weapon bazooka = new Weapon ("bazooka", "bronze", 3 );
        Armor helmet = new Armor ("helmet", "cheese", 2);

        Inventory specific = new Inventory(bazooka, helmet);

        //Inventory should be not null, should have the requisite objects, and the objects should have corrects specs. (Not testing all of those, one is enough.)
        assertNotNull(specific);
        assertEquals(helmet, specific.getArmor());
        assertEquals(bazooka, specific.getWeapon());
        assertEquals("cheese", specific.getArmor().getMaterial());

    }


    @Test
    public void NewInventoryLeveledTest() {

        Inventory leveled = new Inventory(5);

        //Inventory and its objects should be not null. Included weapon should have a description, thus asserting it's correctly built as well. Make sure equipment doesn't get higher bonus than specified.
        assertNotNull(leveled);
        assertNotNull(leveled.getWeapon());
        assertNotNull(leveled.getArmor());
        assertNotEquals("", leveled.getWeapon().getDescription());
        assertTrue(leveled.getArmor().getBonus() <= 5);

    }

    @Test
    public void NewInventoryTest() {

        Inventory random = new Inventory();

        //Inventory and its objects should be not null. Included weapon should have a description, thus asserting it's correctly built as well.
        assertNotNull(random);
        assertNotNull(random.getWeapon());
        assertNotNull(random.getArmor());
        assertNotEquals("", random.getWeapon().getDescription());
        assertTrue(random.getArmor().getBonus() <= 5);
    }
}
