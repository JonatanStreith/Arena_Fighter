package jonst;

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

        String playerName = askUserFor("What is your name? ");
        int playerAttack = Integer.parseInt((askUserFor("Set your attack: ")));
        int playerDefense = Integer.parseInt((askUserFor("Set your defense: ")));

        Chara player = new Chara(playerName, playerAttack, playerDefense);     //Creates player character


        do {
            Chara opponent = new Chara();   //Creates an opponent

            System.out.println("You face " + opponent.getName() + " in the arena!\n They have an attack of " + opponent.getAttack() + " and defense of " + opponent.getDefense() + "!");

            askUserFor("[Press return to continue]");

            Battle brawl = new Battle(player, opponent);

            brawl.fight();


            if (brawl.getOutcome() == "victory") {

                if (askUserFor("Do you want to continue? ").equals("y"))
                    continueFight = true;
                else
                    continueFight = false;
                System.out.println("You decide to get out while the getting's good.");

            } else {
                System.out.println("You have died.");
                continueFight = false;
            }


            if (continueFight) {        //If you continue to fight, you get a new weapon or armor
                System.out.println("You receive spoils of victory!");

                boolean youGetWeapon = (Math.random() > 0.5) ? true : false;    //Fifty-fifty or so, you get weapon or armor

                if(youGetWeapon){       //If you get a wapon
                    Weapon newWeapon = new Weapon();
                    String choice = askUserFor("You get a " + newWeapon.getDescription() + "! Do you want to use it instead of your current weapon? (y/n)");

                    if(choice.toLowerCase().equals("y")){

                    } else{}


                } else{                 //If you get an armor

                }


            }


        } while (continueFight);


        System.out.println("Thanks for playing!");

        inputReader.close();
    }

    static String askUserFor(String term) {     //Multi-use method for getting strings
        System.out.print(term);
        return inputReader.nextLine();
    }

}
