package main.java.csci305.javalab;

/**
 * This class extends Player super class.
 * MyBot always will do the same move as its opponent.
 * @author Olexandr Matveyev
 */
public class MyBot extends Player
{
    /**
     * Constructor accepts name of the player which is String type.
     * @param name: String
     */
    public MyBot(String name)
    {
        super(name);
    }

    /**
     * This method returns the first element from the lastPlayedElement Stack.
     * Elements are added to the stack in the Main class.
     * The lastPlayedElement Stack is defined in the Main class.
     * @return object: Element
     */
    @Override
    public Element play()
    {
        Element tmp = null;
        if(getCurrentPlayedElement() == null)
        {
            // First move is random
            Player player = new RandomBot("Random");
            tmp = player.play();
        }
        else
        {
            tmp = getCurrentPlayedElement();
        }

        return tmp;
    }
}