/**
 * This program is a turn based battle simulator between 2 characters.
 * @author Juan Villegas
 * @author Iman Chaudhry 
 * COSC-1437 Mondays/Wednesdays 11:00am-12:45pm
 */
import java.util.Random;

public class BattleSimulation
{
    public static void main(String[] args) 
    {
        // 70% chance of attacking and a 30% chance of healing

        // Constants for battle 
        final int MIN_HEALTH = 0;
        final int MIN_CHOICE = 1;
        final int MAX_CHOICE = 10;
        final int HEAL_THRESHOLD = 3;

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
            // Generate a random number from 1 - 10 (x > 3 being 70% and x <= 3 being 30%) to choose what the characters do
            int randomNumCharacter1 = rnd.nextInt(MAX_CHOICE) + MIN_CHOICE;
            int randomNumCharacter2 = rnd.nextInt(MAX_CHOICE) + MIN_CHOICE;

            // Depending on what the random number generators makes, do whichever action represent the percentage
            if (randomNumCharacter1 > HEAL_THRESHOLD && randomNumCharacter2 > HEAL_THRESHOLD)            
            {
                System.out.println(myCharacter1.getCharacterName() + " chooses to attack and deals " + myCharacter1.attack(myCharacter2) + " damage!");
                System.out.println(myCharacter2.getCharacterName() + " chooses to attack and deals " + myCharacter2.attack(myCharacter1) + " damage!");
                System.out.println(separatedLines);
                System.out.println(myCharacter1.getCharacterName() + " has " + myCharacter1.getCharacterHealth() + " health remaining");
                System.out.println(myCharacter2.getCharacterName() + " has " + myCharacter2.getCharacterHealth() + " health remaining");
                System.out.println(dashedLines);
            }
            else if (randomNumCharacter1 <= HEAL_THRESHOLD && randomNumCharacter2 <= HEAL_THRESHOLD)
            {
                System.out.println(myCharacter1.getCharacterName() + " chooses to heal. They gained " + myCharacter1.heal() + " health");
                System.out.println(myCharacter2.getCharacterName() + " chooses to heal. They gained " + myCharacter2.heal() + " health");
                System.out.println(separatedLines);
                System.out.println(myCharacter1.getCharacterName() + " has " + myCharacter1.getCharacterHealth() + " health remaining");
                System.out.println(myCharacter2.getCharacterName() + " has " + myCharacter2.getCharacterHealth() + " health remaining");
                System.out.println(dashedLines);
            }
            else if (randomNumCharacter1 > HEAL_THRESHOLD && randomNumCharacter2 <= HEAL_THRESHOLD)
            {
                System.out.println(myCharacter1.getCharacterName() + " chooses to attack and deals " + myCharacter1.attack(myCharacter2) + " damage!");
                System.out.println(myCharacter2.getCharacterName() + " chooses to heal. They gained " + myCharacter2.heal() + " health");
                System.out.println(separatedLines);
                System.out.println(myCharacter1.getCharacterName() + " has " + myCharacter1.getCharacterHealth() + " health remaining");
                System.out.println(myCharacter2.getCharacterName() + " has " + myCharacter2.getCharacterHealth() + " health remaining");
                System.out.println(dashedLines);
            }
            else if (randomNumCharacter1 <= HEAL_THRESHOLD && randomNumCharacter2 > HEAL_THRESHOLD)
            {
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
        if (myCharacter1.getCharacterHealth() <= MIN_HEALTH && myCharacter2.getCharacterHealth() <= MIN_HEALTH) 
        {
            System.out.println("Sadly, the dual has left them both dead.");
        }
        else if (myCharacter1.getCharacterHealth() >= MIN_HEALTH)
        {
            System.out.println(myCharacter1.getCharacterName() + " has emerged victorious!");
        }
        else 
        {
            System.out.println(myCharacter2.getCharacterName() + " has emerged victorious!");
        }
    }
}
