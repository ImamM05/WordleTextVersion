
import java.util.HashMap;


public class WordleLogic
{
    private final int MAX_TRIES_ALLOWED = 5;
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
    }

    private boolean isWordAcceptable(String userInput) {
        return true; // placeholder
    }
}