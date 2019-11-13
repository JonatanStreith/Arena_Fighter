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





        do {
            Chara opponent = new Chara(player.getLevel());   //Creates an opponent of suitable level, within three levels dif.



            App.askUserFor("\n[Press return to continue]\n");   //Just a pause.



            Battle brawl = new Battle(player, opponent);        //This is where the carnage happens.




            if (brawl.getOutcome() == "victory") {

                continueFight = player.victory(player, opponent);   //Needs chara references for looting and stuff

            } else {

                continueFight = player.defeat();        //Game over.

            }



        } while (continueFight);        //Loop runs once, then continues to run until you die or retire.


        System.out.println("Thanks for playing!");

        App.askUserFor("\n[Press return to continue]\n");   //Just a pause.

        inputReader.close();
    }

    public static String askUserFor(String term) {     //Multi-use method for getting strings
        System.out.print(term);
        return inputReader.nextLine();
    }

}
