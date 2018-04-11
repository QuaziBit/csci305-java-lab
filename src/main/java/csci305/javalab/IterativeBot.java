package main.java.csci305.javalab;

/**
 * This class extends Player super class.
 * @author Olexandr Matveyev
 */
public class IterativeBot extends Player
{
    // This object field defined only in the IterativeBot class and used only in this class.
    // The current currentMove variable will be incremented every time when play() method called.
    private int currentMove = 1;

    /**
     * Constructor accepts name of the player which is String type.
     * @param name: String
     */
    public IterativeBot(String name)
    {
        super(name);
    }

    /**
     * Every time when play() method called the currentMove variable increments,
     * and based on the currentMove value the element will be selected from the moves collection.
     * The moves collection is defined in the Main class.
     * @return object: Element
     */
    @Override
    public Element play()
    {
        Element tmp = null;

        if(currentMove > 5)
        {
            currentMove = 1;
        }

        tmp = Main.moves.get(currentMove);
        currentMove++;

        return tmp;
    }
}
