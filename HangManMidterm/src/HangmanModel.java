import java.util.ArrayList;
import java.util.List;

/*Hangman Midterm
 * 
 * 4/5/15
 * 
 * Project by:  Qaisha Closeil, Tyler Dresslehouse, and Jim Webb
 * 
 */

public class HangmanModel {
 
    private int maximumWrongGuesses, numberOfGuesses, wrongGuesses;
    private List<Character> unguessedLetters;
    private readDictionary phrase;
    private String currentPhrase, hiddenPhrase;
    
    private int length = OptionPanel.num2;
 
    public HangmanModel() {
        this.phrase = new readDictionary();
        this.phrase.readFile("dictionary.txt");
        this.phrase.getWord(3,0);    //insert some things that take the length from the sliders
        
        init();
    }
 
    public void init() {
        this.numberOfGuesses = 0;
        this.wrongGuesses = 0;
        this.maximumWrongGuesses = HangmanShape.maximumWrongGuesses;
        this.unguessedLetters = resetLettersGuessed();
        
        this.currentPhrase = phrase.getWord(length, 0);
        this.hiddenPhrase = phrase.getHiddenPhrase();
    }
    //
    private List<Character> resetLettersGuessed() {
        List<Character> unguessedLetters = new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
            Character c = (char) (i + 'A');
            unguessedLetters.add(c);
        }
        return unguessedLetters;
    }
 
    public boolean isPossibleLetter(String letter) {
        String u = letter.toUpperCase();
        Character c = u.charAt(0);
        return unguessedLetters.contains(c);
    }
    //allows the user to type either an upper case letter or a lower case letter.
    public void guessLetter(String letter) {
        String l = letter.toLowerCase();
        String u = letter.toUpperCase();
 
        StringBuilder builder = new StringBuilder();
        boolean incorrectGuess = true;
        for (int i = 0; i < currentPhrase.length(); i++) {
            String s = currentPhrase.substring(i, i + 1);
            if (l.equals(s.toLowerCase())) {
                builder.append(s);
                incorrectGuess = false;
            } else {
                builder.append(hiddenPhrase.charAt(i));
            }
        }
 
        numberOfGuesses++;
 
        if (incorrectGuess) {
            wrongGuesses++;
        }
 
        Character c = u.charAt(0);
        unguessedLetters.remove(c);
 
        hiddenPhrase = builder.toString();
    }
    //Unsolved if out of guesses
    public boolean isUnsolved() {
        return wrongGuesses >= maximumWrongGuesses;
    }
    //Solved once the word is completed
    public boolean isSolved() {
        boolean isSolved = true;
 
        for (int i = 0; isSolved && i < hiddenPhrase.length(); i++) {
            char c = hiddenPhrase.charAt(i);
            if (c == '_') {
                isSolved = false;
            }
        }
 
        return isSolved;
    }
 
    public String getUnguessedLetters() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < unguessedLetters.size(); i++) {
            builder.append(unguessedLetters.get(i));
            if (i < (unguessedLetters.size() - 1)) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
 
    public String getNumberOfGuesses() {
        return Integer.toString(numberOfGuesses);
    }
   
    public List<String> getHiddenPhrase() {                 //secret word
        List<String> lines = new ArrayList<String>();
 
        int size = 12;
        String s = hiddenPhrase;
 
        while (s.length() > size) {
            int pos = 0;
            while (pos >= 0 && pos < size) {
                pos = s.indexOf(" ", pos + 1);
            }
            if (pos >= 0) {
                String t = s.substring(0, pos);
                lines.add(expandHiddenPhrase(t));
                s = s.substring(pos + 1);
            } else {
                break;
            }
        }
 
        lines.add(expandHiddenPhrase(s));
 
        return lines;
    }
 
    private String expandHiddenPhrase(String phrase) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            builder.append(phrase.charAt(i));
            if (i < (phrase.length() - 1)) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
 
    public int getWrongGuesses() {
        return wrongGuesses;
    }
 
    public String getCurrentPhrase() {
        return currentPhrase;
    }
 
}