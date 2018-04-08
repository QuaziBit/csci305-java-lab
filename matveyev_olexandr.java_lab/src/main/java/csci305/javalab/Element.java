package main.java.csci305.javalab;

/**
 * The parent class for all game elements
 * @author Olexandr Matveyev
 */
public abstract class Element
{
    // Name holder
    private String name = null;

    /**
     * Element constructor
     * @param name: String
     */
    public Element(String name)
    {
        this.name = name;
    }

    /**
     * This method used to compere elements
     * @param object: Element
     * @return String
     */
    public abstract String compareTo(Element object);

    /**
     * Name getter
     * @return name: String
     */
    public String getName()
    {
        return name;
    }
}
