import java.util.HashMap;

public class WordleLogic
{
    private static final int MAX_TRIES_ALLOWED = 5, MAX_LENGTH = 5;
    private final HashMap<Integer, String> wordList;
    private int cursor;
    private final HashMap<Character, Integer> charFreqMap;
    private final HashMap<Integer, Character> wordIndexMap;
    private String currWord;
    private String modStr;
    private boolean gameOver = false;

    public WordleLogic() {
        wordList = Utility.wordList.setFiveLetterWords();
        cursor = -1;
        charFreqMap = new HashMap<>();
        wordIndexMap = new HashMap<>();
        modStr = "";
    }

    public void setMap() {
        char currChar;
        cursor++;
        currWord = wordList.get(cursor);
        System.out.println(currWord);
        
        for (int i = 0; i < MAX_LENGTH; i++)
        {
            currChar = currWord.charAt(i);
            // logic for creating frequency map
            if (!charFreqMap.containsKey(currChar))
            {
                charFreqMap.put(currChar, 1);
            } else {
                int prevAmt = charFreqMap.get(currChar);
                charFreqMap.put(currChar, prevAmt + 1);
            }
            // adds the word to the index map
            wordIndexMap.put(i, currChar);
        }
    }

    // private helper method
    private boolean isWordAcceptable(String userInput) {
        /** 
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.err.println(userInput +" is not a word.");
        }
        */
        return true; // placeholder
    }

    public void checkWordMatch(String userInput)
    {
        assert isWordAcceptable(userInput);

        char currChar;
        for (int i = 0; i < userInput.length(); i++)
        {
            currChar = userInput.charAt(i);

            // character is in the frequency map and its value is > 0
            if (charFreqMap.containsKey(currChar) && charFreqMap.get(currChar) > 0)
            {
                charFreqMap.put(currChar, charFreqMap.get(currChar) - 1); // decrement the frequency of the character

                // checks whether currChar matches the actual character at index i
                if (currChar == wordIndexMap.get(i))
                {
                    // ternary operators to handle edge cases while printing
                    modStr += (i == 0 ? "'" : " '") + currChar + (i == userInput.length() - 1 ? "'" : "' ");
                }
                else
                {
                    // ternary operators to handle edge cases while printing
                    modStr += (i == 0 ? "*" : " *") + currChar + (i == userInput.length() - 1 ? "*" : "* ");
                }
            }
            else 
            {
                modStr += (i == 0 ? "" : " ") + currChar + (i == userInput.length() - 1 ? "" : " ");
            }
        }
    }

    public String getModStr()
    {
        return modStr;
    }
}