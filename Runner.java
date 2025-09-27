public class Runner
{
    public static void main(String [] args)
    {
        String[] words = {"HELLO", "WORLD"};
        String input = "HELLO";

        WordleLogic game1 = new WordleLogic(words);
        game1.setWord();
        game1.checkWordMatch(input);

        System.out.println(game1.getModStr());
    }
}






