import java.util.Random;
public class Character
{
    public int currentHealth = 50;
    private String name;
    private int strength;
    private int speed;

    public Character(String name, int strength, int speed)
    {
        this.name = name;
        this.strength = strength;
        this.speed = speed;
    }

    public int attack()
    {
        final int ATTACK_DAMAGE = 10;
        final int CRITICAL_HIT = 1;
        final int EXTRA_DAMAGE = 5;
        Random rnd = new Random();
        strength += ATTACK_DAMAGE;

        int chance = rnd.nextInt(10) + 1;

        if (chance == CRITICAL_HIT)
        {
            strength += EXTRA_DAMAGE;
        }
        return strength;
    }

    public int heal()
    {
        final int HEALING = 5;
        int healthGained = HEALING + (speed * 2);

        return healthGained;
    }

    public void takeDamage(int damageTaken)
    {
        currentHealth -= damageTaken;
    }
}
