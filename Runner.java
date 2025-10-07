public class Runner
{
    public static void main(String [] args)
    {
        String[] words = {"HELLO", "WORLD"};
        String input = "LLOLS";

        WordleLogic game1 = new WordleLogic(words);
        game1.setWord();
        game1.checkWordMatch(input);

        System.out.print("Here is the word you inputted: " + input + "\n");
        System.out.println(game1.getModStr());
    }
}






