package main.java.csci305.javalab;

/**
 * @author Olexandr Matveyev
 */
public class Outcome
{
    private String value1 = null;
    private String value2 = null;

    public Outcome()
    {

    }

    public String getOutput(String val1, String val2)
    {
        value1 = val1;
        value2 = val2;
        return value1 + " --- " + value2;
    }
}
