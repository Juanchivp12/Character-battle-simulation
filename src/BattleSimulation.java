import java.util.Random;
import java.util.Scanner;

public class BattleSimulation
{
    public static void main(String[] args) 
    {
        Random rnd = new Random();
        Character michael = new Character("michael", 4, 1);
        Character klaus = new Character("Klaus", 3, 2);

        klaus.takeDamage(michael.attack());
        System.out.println(klaus.getCurrentHealth());
    }
}
