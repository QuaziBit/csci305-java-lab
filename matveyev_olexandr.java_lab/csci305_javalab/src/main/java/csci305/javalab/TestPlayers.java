package main.java.csci305.javalab;

/**
 * @author Olexandr Matveyev
 */
public class TestPlayers
{
    public static void main(String args[])
    {
        Player p1 = new StupidBot("StupidBot");
        Player p2 = new RandomBot("RandomBot");
        Element p1move = p1.play();
        Element p2move = p2.play();
        System.out.println(p1move.compareTo(p2move));
    }
}
