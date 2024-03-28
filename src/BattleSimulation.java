/**
 * This program is a turn based battle simulator between 2 characters.
 * @author Juan Villegas, Iman Chaudhry COSC-1437 Mondays/Wednesdays 11:00am-12:45pm
 */
import java.util.Random;

public class BattleSimulation
{
    public static void main(String[] args) 
    {
        // Constants for battle 
        final int BOTH_ATTACK = 1;
        final int BOTH_HEAL = 2;
        final int CHAR1_ATTACKS_CHAR2_HEALS = 3;
        final int CHAR1_HEALS_CHAR2_ATTACKS = 4;
        final int MIN_HEALTH = 0;
        final int MIN_CHOICE = 1;
        final int MAX_CHOICE = 4;

        // Symbol Strings for formatting output
        String separatedLines = "- - - - - - - - - - - - - - - - - - - - - - - - - - -";
        String dashedLines = "-----------------------------------------------------";
        String asterisks = "**************************";

        // Create Random object
        Random rnd = new Random();
        
        // Create character objects
        Character myCharacter1 = new Character("SpongeBob the square pants", 4, 1, 50);
        Character myCharacter2 = new Character("Patrick the star", 3, 2, 50);
        
        // Output for introducing characters
        System.out.println("It's a duel to the death, let's welcome our opponents.");
        System.out.println(myCharacter1.getCharacterName() + " and " + myCharacter2.getCharacterName());
        System.out.println("Let the battle commence!");
        System.out.println(asterisks);

        // While loop, stops when someone dies
        while (myCharacter1.getCharacterHealth() > MIN_HEALTH && myCharacter2.getCharacterHealth() > MIN_HEALTH)
        {
            // Generate a random number from 1 - 4 to choose what the characters do
            int battle = rnd.nextInt(MAX_CHOICE) + MIN_CHOICE;
            
            switch (battle)
            {
                case BOTH_ATTACK:
                System.out.println(myCharacter1.getCharacterName() + " chooses to attack and deals " + myCharacter1.attack(myCharacter2) + " damage!");
                System.out.println(myCharacter2.getCharacterName() + " chooses to attack and deals " + myCharacter2.attack(myCharacter1) + " damage!");
                System.out.println(separatedLines);
                System.out.println(myCharacter1.getCharacterName() + " has " + myCharacter1.getCharacterHealth() + " health remaining");
                System.out.println(myCharacter2.getCharacterName() + " has " + myCharacter2.getCharacterHealth() + " health remaining");
                System.out.println(dashedLines);
                break;

                case BOTH_HEAL:
                System.out.println(myCharacter1.getCharacterName() + " chooses to heal. They gained " + myCharacter1.heal() + " health");
                System.out.println(myCharacter2.getCharacterName() + " chooses to heal. They gained " + myCharacter2.heal() + " health");
                System.out.println(separatedLines);
                System.out.println(myCharacter1.getCharacterName() + " has " + myCharacter1.getCharacterHealth() + " health remaining");
                System.out.println(myCharacter2.getCharacterName() + " has " + myCharacter2.getCharacterHealth() + " health remaining");
                System.out.println(dashedLines);
                break;

                case CHAR1_ATTACKS_CHAR2_HEALS:
                System.out.println(myCharacter1.getCharacterName() + " chooses to attack and deals " + myCharacter1.attack(myCharacter2) + " damage!");
                System.out.println(myCharacter2.getCharacterName() + " chooses to heal. They gained " + myCharacter2.heal() + " health");
                System.out.println(separatedLines);
                System.out.println(myCharacter1.getCharacterName() + " has " + myCharacter1.getCharacterHealth() + " health remaining");
                System.out.println(myCharacter2.getCharacterName() + " has " + myCharacter2.getCharacterHealth() + " health remaining");
                System.out.println(dashedLines);

                case CHAR1_HEALS_CHAR2_ATTACKS:
                System.out.println(myCharacter1.getCharacterName() + " chooses to heal. They gained " + myCharacter1.heal() + " health");
                System.out.println(myCharacter2.getCharacterName() + " chooses to attack and deals " + myCharacter2.attack(myCharacter1) + " damage!");
                System.out.println(separatedLines);
                System.out.println(myCharacter1.getCharacterName() + " has " + myCharacter1.getCharacterHealth() + " health remaining");
                System.out.println(myCharacter2.getCharacterName() + " has " + myCharacter2.getCharacterHealth() + " health remaining");
                System.out.println(dashedLines);
            }
        }

        // Battle ended output
        System.out.println(asterisks);
        System.out.println("The battle has ended.");

        // Outputs who won
        if (myCharacter1.getCharacterHealth() >= MIN_HEALTH)
        {
            System.out.println(myCharacter1.getCharacterName() + " has emerged victorious!");
        }
        else
        {
            System.out.println(myCharacter2.getCharacterName() + " has emerged victorious!");
        }
    }

    public static void battle()
    {
        
        
    }
}
