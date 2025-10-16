public class Runner
{
    public static void main(String [] args)
    {
        String input = "WORLD";

        WordleLogic game1 = new WordleLogic();
        game1.setMap();
        game1.checkWordMatch(input);

        System.out.print("Here is the word you inputted: " + input + "\n");
        System.out.println(game1.getModStr());
    }
}






