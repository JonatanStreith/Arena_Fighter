package jonst;

import Model.Armor;
import Model.Battle;
import Model.Chara;
import Model.Weapon;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static Scanner inputReader;

    public static void main(String[] args) {

        inputReader = new Scanner(System.in);
        boolean continueFight = true;


        System.out.println("Welcome to the arena!");


        Chara player = Chara.createPlayerCharacter();     //Creates player character


        System.out.println("You start with a " + player.getWeapon().getDescription() +
                           " and wear " + player.getArmor().getDescription() + ".");


        do {
            Chara opponent = new Chara(Chara.getMatchingLevel(player.getLevel()));   //Creates an opponent of suitable level

            askUserFor("[Press return to continue]");

            Battle brawl = new Battle(player, opponent);




            if (brawl.getOutcome() == "victory") {

                player.levelUp();

                if (askUserFor("Do you want to continue? ").equals("y")) {
                    continueFight = true;
                    player.getLoot();
                } else {
                    continueFight = false;
                    System.out.println("You decide to get out while the getting's good. You reached level " + player.getLevel() + " before retiring.");
                }

            } else {
                System.out.println("You have died. You reached level " + player.getLevel() + " before perishing.");
                continueFight = false;
            }


        } while (continueFight);


        System.out.println("Thanks for playing!");

        inputReader.close();
    }

    public static String askUserFor(String term) {     //Multi-use method for getting strings
        System.out.print(term);
        return inputReader.nextLine();
    }

}
