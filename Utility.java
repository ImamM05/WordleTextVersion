import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


@FunctionalInterface
interface WordsFiveLetter {
    HashMap<Integer, String> setFiveLetterWords();
}

public final class Utility
{
    //lambda expression
    public static WordsFiveLetter wordList = () ->
    {
        HashMap<Integer, String> words = new HashMap<>();
        File newFile = new File("Five_Letter_Words.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(newFile)))
        {
            String line;
            int count = 0;
            while((line = br.readLine()) != null)
            {
                words.put(count, line.toUpperCase());
                count++;
            }
        }
        catch (IOException e)
        {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return words;
    };
}