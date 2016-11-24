package javaapplication1;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Clément
 */
public class ScrabbleConsole {

    /**
     * @param args the command line arguments
     */

    public ScrabbleConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Scrabble assistant");
        //Dictionnary dico = new Dictionnary();
        Dictionnary dico = new Dictionnary("./fr_FR_utf8.dico");
        //System.out.println(Arrays.toString(dico.getWordList()));
        dico.displayExo10();
        /*System.out.println("Please enter a word that you want test.");
        String word = sc.nextLine();*/
        System.out.println("Please now enter letters that you can place");
        String letters = sc.nextLine();
        char toTestLetters[] = letters.toCharArray();

        // System.out.println(dico.replaceFrenchCharacter(word));

        ScrabbleComparator sc1 = new ScrabbleComparator(toTestLetters);
        String[] wordsFound = dico.getWordsThatCanBeComposed(toTestLetters);
        if (wordsFound != null){
            Arrays.sort(wordsFound, sc1);
            for (String s : wordsFound){
                System.out.println(s + " " + Arrays.toString(Dictionnary.getComposition(s, toTestLetters)) + " - " + sc1.wordValue(s) + " points");
            }
        }
        //System.out.println("Composition for score: " + Arrays.toString(Dictionnary.getComposition(word, toTestLetters)));
        //System.out.println(dico.mayBeComposed(word , toTestLetters));
        //System.out.println(Arrays.toString(wordsFound));
        //System.out.println(sc1.wordValue(word));
    }

    public static void main(String[] args) {
        ScrabbleConsole sc = new ScrabbleConsole();
    }
}

