/**
 * This is the character class
 * @author Juan Villegas
 * @author Iman Chaudhry 
 * COSC-1437 Mondays/Wednesdays 11:00am-12:45pm
 */
import java.util.Random;

public class Character
{
    private String name;
    private int strength;
    private int speed;
    private int health;

    /**
     * This is a parametized constructor
     * @author Juan Villegas
     * @param name the character's name, a String
     * @param strength the character's strength, an integer
     * @param speed the character's speed, an integer
     */
    public Character(String name, int strength, int speed, int health)
    {
        this.name = name;
        this.strength = strength;
        this.speed = speed;
        this.health = health;
    }

    /**
     * This is a copy constructor
     * @author Juan Villegas
     * @param character an object reference variable
     */
    public Character(Character character)
    {
        this.name = character.name;
        this.strength = character.strength;
        this.speed = character.speed;
        this.health = character.health;
    }

    /**
     * This method gets the character's name
     * @author Juan Villegas
     * @author Iman Chaudhry
     * @return the character's name, a string
     */
    public String getCharacterName()
    {
        return name;
    }

    /**
     * This method gets the character's strength
     * @author Juan Villegas
     * @author Iman Chaudhry
     * @return the character's strength, an int
     */
    public int getCharacterStrength()
    {
        return strength;
    }

    /**
     * This method gets the character's strength
     * @author Juan Villegas
     * @author Iman Chaudhry
     * @return the character's speed, an int
     */
    public int getCharacterSpeed()
    {
        return speed;
    }

    /**
     *  This method gets the characters current health
     * @author Juan Villegas
     * @author Iman Chaudhry
     * @return the character's current health, an integer
     */
     public int getCharacterHealth()
     {
         return health;
     }

    /**
     * This method determines how much damage is dealt if an attack is chosen
     * @author Juan Villegas
     * @param character an object reference variable
     * @return strength, an integer
     */
    public int attack(Character character)
    {
        // Constants 
        final int ATTACK_DAMAGE = 10;
        final int CRITICAL_HIT = 1;
        final int EXTRA_DAMAGE = 5;

        int damage = strength + ATTACK_DAMAGE;

        // Making a random object and generating a random int
        Random rnd = new Random();
        int chance = rnd.nextInt(10) + 1;

        // if random number is 1 (10% chance), add strength to base attack damage and extra damage for a critical hit)
        if (chance == CRITICAL_HIT)
        {
            damage += EXTRA_DAMAGE;
            System.out.print("**Critical hit!** ");
        }
        // character sent to this method takes damage
        character.takeDamage(damage);
        return damage;
    }

    /**
     * This method is called when the character chooses to heal, it determines how much they will heal
     * @author Juan Villegas
     * @author Iman Chaudhry
     * @return how much health was gained, an integer
     */
    public int heal()
    {
        // constant
        final int HEALING = 5;

        // Health gained is base healing plus 2 times the speed
        int healthGained = HEALING + (speed * 2);

        // add amount of health gained to health attribute
        health += healthGained;

        return healthGained;
    }

    /**
     * This method is called whenever a character takes damage, 
     * it subtracts current health from how much damage was dealt to them
     * @author Juan Villegas
     * @author Iman Chaudhry
     * @param damageTaken how much damage was taken, an integer
     */
    public void takeDamage(int damageTaken)
    {
        health -= damageTaken;
    }

    /**
     * This is a toString method, whenever a reference variable is printed, this will be printed
     * @author Juan Villegas
     * @return a formatted string of the characters data
     */
    public String toString()
    {
        String characterString = "Your character's name is " + name + "\n" +
                                 "Their strength is " + strength + "\n" +
                                 "Their speed is " + speed;
        return characterString;
    }

    /**
     * This is an equals method, it determines if two characters have equal data
     * @author Juan Villegas
     * @param ch a character reference object
     * @return a boolean to determine if the characters are equal to eachother
     */
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

    /**
     * This is a copy method, it copies a character's data into another
     * @author Juan Villegas
     * @return a copy of the character
     */
    public Character copy()
    {
        return new Character(this);
    }
}
