package main.java.csci305.javalab;

/**
 * This class extends Player super class.
 * @author Olexandr Matveyev
 */
public class LastPlayBot extends Player
{
    // Move counter for this object
    private int count = 0;

    /**
     * Constructor accepts name of the player which is String type.
     * @param name: String
     */
    public LastPlayBot(String name)
    {
        super(name);
    }

    /**
     * This method returns the second element from the lastPlayedElement Stack.
     * Elements are added to the stack in the Main class.
     * The lastPlayedElement Stack is defined in the Main class.
     * @return object: Element
     */
    @Override
    public Element play()
    {
        Element tmp = null;
        if(count == 0)
        {
            // First move is random
            Player player = new RandomBot("Random");
            tmp = player.play();
        }
        else
        {
            tmp = getLastPlayedElement();
        }
        count++;


        return tmp;
    }
}
