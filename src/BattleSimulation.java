import java.util.Random;
import java.util.Scanner;

public class BattleSimulation
{
    public static void main(String[] args) 
    {
        final int BOTH_ATTACK = 1;
        final int BOTH_HEAL = 2;
        final int CHAR1_ATTACKS_CHAR2_HEALS = 3;
        final int CHAR1_HEALS_CHAR2_ATTACKS = 4;
        
        Random rnd = new Random();
        Character myCharacter1 = new Character("SpongeBob", 4, 1);
        Character myCharacter2 = new Character("Patrick", 3, 2);

        while (myCharacter1.getCurrentHealth() > 0 && myCharacter2.getCurrentHealth() > 0)
        {
            int battle = rnd.nextInt(4) + 1;
            
            switch (battle)
            {
                case BOTH_ATTACK:
                System.out.println(myCharacter1.getCharacterName() + " chooses to attack and deals " + myCharacter1.attack(myCharacter2) + " damage!");
                System.out.println(myCharacter2.getCharacterName() + " chooses to attack and deals " + myCharacter2.attack(myCharacter1) + " damage!");
                System.out.println(myCharacter1.getCharacterName() + " has " + myCharacter1.getCurrentHealth() + " health remaining");
                System.out.println(myCharacter2.getCharacterName() + " has " + myCharacter2.getCurrentHealth() + " health remaining");
                System.out.println("---------------------------------------------------------------------");
                break;

                case BOTH_HEAL:
                System.out.println(myCharacter1.getCharacterName() + " chooses to heal and deals " + myCharacter1.attack(myCharacter2) + " damage!");
                System.out.println(myCharacter2.getCharacterName() + " chooses to attack and deals " + myCharacter2.attack(myCharacter1) + " damage!");
                System.out.println(myCharacter1.getCharacterName() + " has " + myCharacter1.getCurrentHealth() + " health remaining");
                System.out.println(myCharacter2.getCharacterName() + " has " + myCharacter2.getCurrentHealth() + " health remaining");
                break;

            }
        }
    }
}
