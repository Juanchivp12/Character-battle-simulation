import java.util.Random;
public class Character
{
    private String name;
    private int strength;
    private int speed;
    public final int ATTACK_DAMAGE = 10;

    public Character(String name, int strength, int speed)
    {
        this.name = name;
        this.strength = strength;
        this.speed = speed;
    }

    public int attack()
    {
        final int CRITICAL_HIT = 1;
        Random rnd = new Random();
        strength += ATTACK_DAMAGE;

        int chance = rnd.nextInt(10) + 1;

        if (chance == CRITICAL_HIT)
        {
            strength += 5;
        }
        return strength;
        
    }
}
