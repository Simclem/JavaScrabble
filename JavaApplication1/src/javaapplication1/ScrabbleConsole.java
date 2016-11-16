/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package javaapplication1;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Clément
 */
public class ScrabbleConsole
{
    
        /**
         * @param args the command line arguments
         */
    

        public ScrabbleConsole()
        {
            Scanner sc = new Scanner(System.in);
                
                

                
                System.out.println("Welcome to the Scrabble assistant");
                //Dictionnary dico = new Dictionnary();
                Dictionnary dico = new Dictionnary("./fr_FR_utf8.dico");
                //System.out.println(Arrays.toString(dico.getWordList()));
                dico.displayExo10();
                System.out.println("Please enter a word that you want test.");
                String word = sc.nextLine();
                System.out.println("Please now enter letters that you can place");
                String letters = sc.nextLine();
                char toTestLetters[] = letters.toCharArray();
                System.out.println(dico.mayBeComposed(word , toTestLetters));
        }

        public static void main(String[] args)
        {
                ScrabbleConsole sc = new ScrabbleConsole();
        }
    
}
