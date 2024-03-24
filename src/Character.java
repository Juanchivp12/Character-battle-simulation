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
        Random rnd = new Random();

        int criticalHit = rnd.nextInt(10) + 1;

        if (criticalHit == 1)
        {
            strength += ATTACK_DAMAGE + 5;
        }
        else
        {
            strength += ATTACK_DAMAGE;
        }
        return strength;
        
    }
}
