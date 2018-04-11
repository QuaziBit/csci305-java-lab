package main.java.csci305.javalab;

/**
 * The parent class for all players
 * @author Olexandr Matveyev
 */
public abstract class Player
{
    // Name holder
    private String name = null;

    // These fields used for LastPlayBot and MyBot, but others children of the Player class
    // also have access to this fields
    private Element lastPlayedElement = null;
    private Element currentPlayedElement = null;

    /**
     * Player constructor
     * @param name: String
     */
    public Player(String name)
    {
        this.name = name;
    }

    /**
     * This method used to return an selected element
     * @return object: Element
     */
    public abstract Element play();

    /**
     * Name getter
     * @return name: String
     */
    public String getName()
    {
        return name;
    }

    // Setters and getter for the LastPlayBot and MyBot
    public void setLastPlayedElement(Element lastPlayedElement)
    {
        this.lastPlayedElement = lastPlayedElement;
    }

    public void setCurrentPlayedElement(Element currentPlayedElement)
    {
        this.currentPlayedElement = currentPlayedElement;
    }

    public Element getLastPlayedElement()
    {
        return lastPlayedElement;
    }

    public Element getCurrentPlayedElement()
    {
        return currentPlayedElement;
    }
}
