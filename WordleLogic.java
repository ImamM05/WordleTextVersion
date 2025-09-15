
import java.util.HashMap;


public class WordleLogic
{
    private final int MAX_TRIES_ALLOWED = 5, MAX_LENGTH = 5;
    private String[] wordList = new String[20];
    private int cursor;
    private HashMap<Character, Integer> lettFreqMap = new HashMap<>();
    private String currWord;
    private String modVal;
    private boolean gameOver = false;

    public WordleLogic(String[] arr) {
        wordList = arr;
        cursor = -1;
    }

    private void setWord() {
        cursor++;
        currWord = wordList[cursor];
        
        for (int i = 0; i < MAX_LENGTH; i++)
        {
            int amount = 1;
            if (lettFreqMap.containsKey(currWord.charAt(i)))
            {
                lettFreqMap.put(currWord.charAt(i), amount++);
            } else {
                lettFreqMap.put(currWord.charAt(i), amount);
            }
        }
    }

    private boolean isWordAcceptable(String userInput) {
        return true; // placeholder
    }
}