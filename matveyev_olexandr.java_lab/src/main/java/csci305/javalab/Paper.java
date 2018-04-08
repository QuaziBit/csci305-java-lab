package main.java.csci305.javalab;

/**
 * This class extends Element super class
 * @author Olexandr Matveyev
 */
public class Paper extends Element
{
    /**
     * Constructor accepts name of the element which is String type
     * @param str: String
     */
    public Paper(String str)
    {
        super(str);
    }

    /**
     * This method accepts object which is Element type,
     * and comperes this name with that name [another element name].
     * Builds String by using Outcome class.
     * @param object: Element
     * @return name of the element: String
     */
    @Override
    public String compareTo(Element object)
    {
        Outcome outcome = new Outcome();

        String out = null;
        String str = null;

        int res = this.getName().compareTo(object.getName());

        // If names is equal the: Tie
        // else uses pre-build if statements to identify: Win or Lose
        if(res == 0)
        {
            out = outcome.getOutput(this.getName() + " equals " + this.getName(), "Tie");
        }
        else if (res >= 1)
        {
            if(object.getName().equals("Lizard"))
            {
                str = " eats ";
                out = outcome.getOutput(object.getName() + str + this.getName(), "Lose");
            }
        }
        else if (res <= -1)
        {
            if(object.getName().equals("Scissors"))
            {
                str = " cut ";
                out = outcome.getOutput(object.getName() + str + this.getName(), "Lose");
            }
            else if(object.getName().equals("Rock"))
            {
                str = " covers ";
                out = outcome.getOutput(this.getName() + str + object.getName(), "Win");
            }
            else if(object.getName().equals("Spock"))
            {
                str = " disproves ";
                out = outcome.getOutput(this.getName() + str + object.getName(), "Win");
            }
        }

        return out;
    }


    /*
    @Override
    public String compareTo(Element object)
    {
        Outcome outcome = new Outcome();

        String out = null;
        String str = null;

        //Rock-Paper-Scissors-Lizard-Spock
        if(object.getName().equals("Paper"))
        {
            out = outcome.getOutput(this.getName() + " equals " + this.getName(), "Tie");
        }
        else if(object.getName().equals("Rock"))
        {
            str = " covers ";
            out = outcome.getOutput(this.getName() + str + object.getName(), "Lose");
        }
        else if(object.getName().equals("Scissors"))
        {
            str = " cut ";
            out = outcome.getOutput(object.getName() + str + this.getName(), "Win");
        }
        else if(object.getName().equals("Lizard"))
        {
            str = " eats ";
            out = outcome.getOutput(object.getName() + str + this.getName(), "Win");
        }
        else if(object.getName().equals("Spock"))
        {
            str = " disproves ";
            out = outcome.getOutput(this.getName() + str + object.getName(), "Lose");
        }

        return out;
    }
    */



}
