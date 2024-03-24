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

    public Character(Character ch)
    {
        this.name = ch.name;
        this.strength = ch.strength;
        this.speed = ch.speed;
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


    public String toString()
    {
        String characterString = "Your character's name is " + name + "\n" +
                                 "Their strength is " + strength + "\n" +
                                 "Their speed is " + speed;
        return characterString;
    }

    public boolean equals(Character ch)
    {
        boolean status;

        if (name.equals(ch.name) && strength == ch.strength && speed == ch.speed)
        {
            status = true;
        }
        else
        {
            status = false;
        }
        return status;
    }

    public Character copy()
    {
        return new Character(this);
    }
}
