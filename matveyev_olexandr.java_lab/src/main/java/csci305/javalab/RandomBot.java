package main.java.csci305.javalab;

import java.util.Random;

/**
 * This class extends Player super class.
 * @author Olexandr Matveyev
 */
public class RandomBot extends Player
{
    /**
     * Constructor accepts name of the player which is String type.
     * @param name: String
     */
    public RandomBot(String name)
    {
        super(name);
    }

    /**
     * This method generates random number,
     * and based on this number will select predefined element from the moves collection.
     * The moves collection is defined in the Main class.
     * @return object: Element
     */
    @Override
    public Element play()
    {
        Random random = new Random();
        int min = 1;
        int max = 5;
        int randomNumber = random.nextInt((max - min) + 1) + min;

        return Main.moves.get(randomNumber);
    }
}
