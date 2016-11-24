package javaapplication1;
import java.util.Comparator;

public class ScrabbleComparator implements Comparator<String>{
    private char[] letters;

    public ScrabbleComparator(char[] letters){
        this.letters = letters;
    }

    public int letterValue(char letter){
        String[] groupPoints = {"*", "eainorstul", "dmg", "bcp", "fhv", "jq", "kwxyz"};
        String s = "" + letter;
        s = Dictionnary.replaceFrenchCharacter(s);
        CharSequence cs = "" + s;
        if (groupPoints[0].contains(cs)){
            return 0;
        }
        else if (groupPoints[1].contains(cs)){
            return 1;
        }
        else if (groupPoints[2].contains(cs)){
            return 2;
        }
        else if (groupPoints[3].contains(cs)){
            return 3;
        }
        else if (groupPoints[4].contains(cs)){
            return 4;
        }
        else if (groupPoints[5].contains(cs)){
            return 8;
        }
        else if (groupPoints[6].contains(cs)){
            return 10;
        }
        return -1;
    }

    public int lettersValue(char[] letters){
        int score = 0;
        for (int i = 0; i < letters.length; i++){
            score += letterValue(letters[i]);
        }
        return score;
    }

    public int wordValue(String word)
    {
        return lettersValue(Dictionnary.getComposition(word, letters));
    }

    public int compare(String s1, String s2){
        if (wordValue(s1) < wordValue(s2)){
            return 1;
        }
        else if (wordValue(s1) == wordValue(s2)){
            return 0;
        }
        else{
            return -1;
        }
    }
}
