package main.java.csci305.javalab;

/**
 * This class extends Player super class.
 * @author Olexandr Matveyev
 */
public class StupidBot extends Player
{
    /**
     * Constructor accepts name of the player which is String type.
     * @param name: String
     */
    public StupidBot(String name)
    {
        super(name);
    }

    /**
     * This method return predefined element.
     * @return object: Element
     */
    @Override
    public Element play()
    {
        int move = 1;

        return Main.moves.get(move);
    }
}