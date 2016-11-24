/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Clément
 */

public class Dictionnary {
    private final String[] Dico;
    private int nbWord;

    public Dictionnary() {
        nbWord = 12;
        Dico = new String[nbWord];
        Dico[0] = "abricot";
        Dico[1] = "châtaigne";
        Dico[2] = "groseille";
        Dico[3] = "pomme";
        Dico[4] = "tomate";

    }
    public Dictionnary(String PathGiven) {
        int i = 0;
        List < String > Lines = null;
        Path pathFile = Paths.get(PathGiven);
        try {
            Lines = Files.readAllLines(pathFile, Charset.forName("UTF-8"));

        } catch (IOException e) {
            System.out.println("Fichier introuvable");

        }


        nbWord = Integer.parseInt(Lines.get(0));
        Dico = new String[nbWord];

        for (i = 0; i < nbWord; i++) {
            Dico[i] = Lines.get(i + 1);
        }
    }

    public String[] getWordList() {
        int i = 0;
        return Dico;
    }

    public void printDictionnary() {
        int i;
        for (i = 0; i < nbWord; i++) {
            System.out.println(Dico[i] + "\n");
        }
    }

    public void printNbWord() {
        System.out.println(this.nbWord);
    }


    public void displayExo10() {
        if (nbWord > 1) {
            System.out.println(this.nbWord + " words loaded. From " + Dico[0] + " to " + Dico[nbWord - 1]);
        } else {
            if (nbWord == 1) {
                System.out.println("Only one word found : " + Dico[0]);
            } else {
                System.out.println("0 word founded. Sorry, the dictionnary is empty or the file was not founded");
            }
        }
    }

    public boolean isValidWord(String str) {
        int i;
        boolean found = false;
        for (i = 0; i < nbWord; i++) {

            if (Dico[i].equals(str)) {
                found = true;
            }

        }
        return found;
    }

    public static String replaceFrenchCharacter(String S) {
        int nbcharoe = 0;
        int nbcharae = 0;
        S = S.replace('à', 'a');
        S = S.replace('â', 'a');
        S = S.replace('ä', 'a');
        S = S.replace('ç', 'c');
        S = S.replace('Ç', 'C');
        S = S.replace('é', 'e');
        S = S.replace('è', 'e');
        S = S.replace('ê', 'e');
        S = S.replace('ë', 'e');
        S = S.replace('ï', 'i');
        S = S.replace('î', 'i');
        S = S.replace('ô', 'o');
        S = S.replace('ö', 'o');
        S = S.replace('ù', 'u');
        S = S.replace('ü', 'u');
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'œ') {
                nbcharoe += 1;
            }
            if (S.charAt(i) == 'æ') {
                nbcharae += 1;
            }
        }

        if ((nbcharoe == 0) && (nbcharae == 0)) {
            return S;
        } else {
            String newS = new String();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == 'æ') {
                    newS += 'a';
                    newS += 'e';
                } else {
                    if (S.charAt(i) == 'œ') {
                        newS += 'o';
                        newS += 'e';
                    } else {
                        newS += S.charAt(i);
                    }
                }
            }
            return newS;
        }
    }

    public String[] getWordsThatCanBeComposed(char[] letters) {
        int nbWordRetained = 0;
        for (int i = 0; i < nbWord; i++) {
            if (mayBeComposed(Dico[i], letters) == true) {
                nbWordRetained += 1;
            }
        }
        if (nbWordRetained == 0) {
            System.out.println("We can't build a word with this letters");
            return null;
        } else {
            int y = 0;
            String wordComposed[] = new String[nbWordRetained];

            for (int i = 0; i < nbWord; i++) {
                if (mayBeComposed(Dico[i], letters) == true) {
                    wordComposed[y] = Dico[i];
                    //System.out.println(wordComposed[y]);
                    y += 1;

                }
            }
            //System.out.println(y);
            return wordComposed;
        }
    }

    public boolean mayBeComposed(String word, char[] letters) {
        /*int i;
        int y;
        int cptLetters;
        char wordComponent [] = word.toCharArray();
        for ( i = 0 ; i < wordComponent.length; i++)
        {
            cptLetters = 0;
            for (y=0; y < letters.length; y++)
            {
                if(Character.toUpperCase(wordComponent[i]) == Character.toUpperCase(letters[y]))
                {
                    cptLetters +=1;
                }

            }
            if (cptLetters == 0 )
            {
               // System.out.println("The caracter : " + wordComponent[i]+ " was not found.");
                return false;
            }
        }
        return true;*/

        boolean[] isUsed = new boolean[letters.length];
        Arrays.fill(isUsed, false);
        word = replaceFrenchCharacter(word);

        int lettersPresent = 0;
        for (int j = 0; j < word.length(); j++) {
            for (int i = 0; i < letters.length; i++) {
                if (Character.toLowerCase(letters[i]) == Character.toLowerCase(word.charAt(j)) && !isUsed[i]) {
                    isUsed[i] = true;
                    lettersPresent++;
                    break;
                }
                if (letters[i] == '*' && !isUsed[i]) {
                    isUsed[i] = true;
                    lettersPresent++;
                }
            }
        }
        return lettersPresent >= word.length();
    }

    public static char[] getComposition(String word, char[] letters) {
        boolean[] isUsed = new boolean[letters.length];
        Arrays.fill(isUsed, false);
        word = replaceFrenchCharacter(word);

        int isUsedNumber = 0;
        for (int j = 0; j < word.length(); j++) {
            for (int i = 0; i < letters.length; i++) {
                if (Character.toLowerCase(letters[i]) == Character.toLowerCase(word.charAt(j)) && !isUsed[i]) {
                    isUsed[i] = true;
                    isUsedNumber++;
                    break;
                }
                if (letters[i] == '*' && !isUsed[i]){
                    isUsed[i] = true;
                    isUsedNumber++;
                }
            }
        }

        char[] compositionChar = new char[isUsedNumber];
        int j = 0;

        for (int i = 0; i < letters.length; i++) {
            if (isUsed[i] && compositionChar[j] != '*') {
                compositionChar[j] = letters[i];
                j++;
            }
        }

        if (isUsedNumber == 0)
            return null;
        return compositionChar;
    }
}
