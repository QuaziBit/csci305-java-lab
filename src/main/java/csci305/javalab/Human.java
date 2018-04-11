package main.java.csci305.javalab;

import java.util.Scanner;

/**
 * This class extends Player super class.
 * @author Olexandr Matveyev
 */
public class Human extends Player
{
    /**
     * Constructor accepts name of the player which is String type.
     * @param name: String
     */
    public Human(String name)
    {
        super(name);
    }

    /**
     * This method returns an element based on the user choice.
     * Element will be selected from the moves collection.
     * The moves collection is defined in the Main class.
     * @return object: Element
     */
    @Override
    public Element play()
    {
        boolean isValid = false;
        int move = 0;

        // Print available options
        for(int i = 1; i < ( Main.moves.size() + 1 ); i++ )
        {
            System.out.printf("(%d) : %s\n", i, Main.moves.get(i).getName());
        }

        // After input was valid break the loop if not keep asking user for input
        while (!isValid)
        {
            System.out.printf("%s", "Enter your move: ");

            try
            {
                // Check just in case if input is numeric or not

                Scanner scanner =new Scanner(System.in);
                move = scanner.nextInt();
                isValid = false;
                if(move < 1 || move > 5)
                {
                    System.out.printf("%s\n", "Invalid move. Please try again.");
                    isValid = false;
                }
                else if(move >= 1 || move <= 5)
                {
                    isValid = true;
                }
            }
            catch (Exception e)
            {
                System.out.printf("%s\n", "Invalid move. Please try again.");
                isValid = false;
                move = 0;
            }
        }
        System.out.printf("\n");

        return Main.moves.get(move);
    }
}