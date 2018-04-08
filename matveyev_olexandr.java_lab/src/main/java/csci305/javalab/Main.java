package main.java.csci305.javalab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Olexandr Matveyev
 */
public class Main
{
    // Collection of Elements
    public static final Map<Integer,Element> moves = new HashMap<Integer, Element>();
    static
    {
        moves.put(1, new Rock("Rock"));
        moves.put(2, new Paper("Paper"));
        moves.put(3, new Scissors("Scissors"));
        moves.put(4, new Lizard("Lizard"));
        moves.put(5, new Spock("Spock"));
    };


    // Players
    private static Player player1 = null;
    private static Player player2 = null;

    // Player menu
    private static final Map<Integer,String> players = new HashMap<Integer, String>();
    static
    {
        players.put(1, "StupidBot");
        players.put(2, "RandomBot");
        players.put(3, "IterativeBot");
        players.put(4, "LastPlayBot");
        players.put(5, "Human");
        players.put(6, "MyBot");
    };

    // Store user input for player selection
    private static int[] pl_selected = new int[2];


    /**
     * Main method
     * @param args
     */
    public static void main(String args[])
    {
        System.out.printf("\n%s\n\n", "Welcome to Rock, Paper, Scissors, Lizard, Spock, implemented by Olexandr Matveyev.");
        userInput();
        buildPlayer();
        start();
    }

    /**
     * This function responsible for the game process
     */
    public static void start()
    {
        int player1score = 0;
        int player2score = 0;

        int roundNum = 1;

        System.out.printf("\n%s vs %s. Go!\n\n", player1.getName(), player2.getName());
        while (roundNum <= 5)
        {
            Element pl1element = null;
            Element pl2element = null;

            //======================================================================//
            // these if-else statements is used for MyBot player
            if(player1.getName().equals("MyBot"))
            {
                pl2element = player2.play();
                player1.setCurrentPlayedElement(pl2element);

                pl1element = player1.play();
                player2.setCurrentPlayedElement(pl1element);

            }
            else if(player2.getName().equals("MyBot"))
            {
                pl1element = player1.play();
                player2.setCurrentPlayedElement(pl1element);

                pl2element = player2.play();
                player1.setCurrentPlayedElement(pl2element);
            }
            else
            {
                pl1element = player1.play();
                pl2element = player2.play();
            }
            //======================================================================//

            // Print info, and compere elements
            //=======================================================================//
            String str = pl1element.compareTo(pl2element);

            player1.setLastPlayedElement(pl2element);
            player2.setLastPlayedElement(pl1element);

            String w = "Win";
            String l = "Lose";
            String t = "Tie";

            System.out.printf("Round %d:\n", roundNum);
            System.out.printf("\tPlayer 1: chose %s\n", pl1element.getName());
            System.out.printf("\tPlayer 2: chose %s\n", pl2element.getName());
            System.out.printf("\t%s\n", str);
            //=======================================================================//

            // Determine winner by searching the keywords [Win, Lose, Tie] in the return string.
            //=======================================================================//
            if(str.indexOf(w) != -1)
            {
                System.out.printf("\tPlayer 1 won the round\n\n");
                player1score++;
            }
            else if(str.indexOf(l) != -1)
            {
                System.out.printf("\tPlayer 1 lose the round\n\n");
                player2score++;
            }
            else if(str.indexOf(t) != -1)
            {
                System.out.printf("\tRound was a tie\n\n");
            }
            //=======================================================================//

            roundNum++;
        }

        // Print which player won
        System.out.printf("The score is %d to %d.\n", player1score, player2score);
        if(player1score == player2score)
        {
            System.out.printf("\nGame was a draw\n");
        }
        else if(player1score > player2score)
        {
            System.out.printf("\nPlayer 1 won\n");
        }
        else if(player1score < player2score)
        {
            System.out.printf("\nPlayer 2 won\n");
        }
    }

    /**
     * This function prompt user to enter player type
     */
    public static void userInput()
    {
        boolean isValid = false;
        int move = 0;
        int pl_count = 1;

        System.out.printf("%s\n", "Please choose two players: ");
        for(int i = 1; i < ( Main.players.size() + 1 ); i++ )
        {
            System.out.printf("(%d) : %s\n", i, Main.players.get(i));
        }
        System.out.printf("\n");

        while (!isValid)
        {
            System.out.printf("Select player %d: ", pl_count);

            try
            {
                Scanner scanner = new Scanner(System.in);
                move = scanner.nextInt();
                isValid = false;
                if(move < 1 || move > 6)
                {
                    System.out.printf("%s\n", "Invalid move. Please try again.");
                    pl_count = 1;
                    isValid = false;

                    pl_selected[0] = 0;
                    pl_selected[1] = 0;
                }
                else if(move >= 1 || move <= 6)
                {
                    pl_selected[pl_count - 1] = move;
                    if(pl_count == 2)
                    {
                        isValid = true;
                        break;
                    }
                    pl_count++;
                }
            }
            catch (Exception e)
            {
                System.out.printf("%s\n", "Invalid move. Please try again.");
                pl_count = 1;
                isValid = false;
                move = 0;
            }
        }
    }

    /**
     * Based on the user input this method creates specific player(s) object(s)
     */
    public static void buildPlayer()
    {
        if(players.get(pl_selected[0]).equals("StupidBot"))
        {
            player1 = new StupidBot("StupidBot");
        }
        else if(players.get(pl_selected[0]).equals("RandomBot"))
        {
            player1 = new RandomBot("RandomBot");
        }
        else if(players.get(pl_selected[0]).equals("IterativeBot"))
        {
            player1 = new IterativeBot("IterativeBot");
        }
        else if(players.get(pl_selected[0]).equals("LastPlayBot"))
        {
            player1 = new LastPlayBot("LastPlayBot");
        }
        else if(players.get(pl_selected[0]).equals("Human"))
        {
            player1 = new Human("Human");
        }
        else if(players.get(pl_selected[0]).equals("MyBot"))
        {
            player1 = new MyBot("MyBot");
        }

        if(players.get(pl_selected[1]).equals("StupidBot"))
        {
            player2 = new StupidBot("StupidBot");
        }
        else if(players.get(pl_selected[1]).equals("RandomBot"))
        {
            player2 = new RandomBot("RandomBot");
        }
        else if(players.get(pl_selected[1]).equals("IterativeBot"))
        {
            player2 = new IterativeBot("IterativeBot");
        }
        else if(players.get(pl_selected[1]).equals("LastPlayBot"))
        {
            player2 = new LastPlayBot("LastPlayBot");
        }
        else if(players.get(pl_selected[1]).equals("Human"))
        {
            player2 = new Human("Human");
        }
        else if(players.get(pl_selected[1]).equals("MyBot"))
        {
            player2 = new MyBot("MyBot");
        }
    }
}
