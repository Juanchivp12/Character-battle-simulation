import java.util.Random;
public class BattleSimulation
{
    public static void main(String[] args) 
    {
        Character michael = new Character("michael", 4, 1);
        Character klaus = new Character("Klaus", 3, 2);

        klaus.takeDamage(michael.attack());
        System.out.println(klaus.getCurrentHealth());
    }
}
