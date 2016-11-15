/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package javaapplication1;
import java.util.Arrays;

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
                System.out.println("Welcome to the Scrabble assistant");
                Dictionnary dico = new Dictionnary();
                System.out.println(Arrays.toString(dico.getWordList()));
        }

        public static void main(String[] args)
        {
                ScrabbleConsole sc = new ScrabbleConsole();
        }
    
}
