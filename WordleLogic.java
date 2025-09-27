
import java.util.HashMap;


public class WordleLogic
{
    private final int MAX_TRIES_ALLOWED = 5, MAX_LENGTH = 5;
    private final String[] wordList;
    private int cursor;
    private final HashMap<Character, Integer> charFreqMap;
    private final HashMap<Integer, Character> wordIndexMap;
    private String currWord;
    private String modStr;
    private boolean gameOver = false;

    public WordleLogic(String[] arr) {
        wordList = arr;
        cursor = -1;
        charFreqMap = new HashMap<>();
        wordIndexMap = new HashMap<>();
        modStr = "";
    }

    private void setWord() {
        cursor++;
        currWord = wordList[cursor];
        
        for (int i = 0; i < MAX_LENGTH; i++)
        {
            int amount = 1;
            if (charFreqMap.containsKey(currWord.charAt(i)))
            {
                charFreqMap.put(currWord.charAt(i), amount++);
            } else {
                charFreqMap.put(currWord.charAt(i), amount);
            }
            wordIndexMap.put(i, currWord.charAt(i));
        }
    }

    private boolean isWordAcceptable(String userInput) {
        return true; // placeholder
    }

    public void checkWordMatch(String inputStr)
    {
        setWord();
        assert isWordAcceptable(inputStr);

        char currChar;
        for (int i = 0; i < inputStr.length(); i++)
        {
            currChar = inputStr.charAt(i);

            // character is in the frequency map and its value is > 0
            if (charFreqMap.containsKey(currChar) && charFreqMap.get(currChar) > 0)
            {
                charFreqMap.put(currChar, charFreqMap.get(currChar) - 1); // decrement the frequency of the character

                // checks whether currChar matches the actual character at index i
                if (currChar == wordIndexMap.get(i))
                {
                    modStr += "'" + currChar + "'";
                }
                else
                {
                    modStr += "*"+ currChar + "*";
                }
            }
            else 
            {
                modStr += currChar;
            }
        }
    }

    public String getModStr()
    {
        return modStr;
    }
}