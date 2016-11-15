/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Clément
 */
public class Dictionnary
{
        private final String[] Dico;
        private int nbWord;

        public Dictionnary()
        {
            int nbWord = 5; 
            Dico = new String[nbWord];
            Dico[0] = "abricot";
            Dico[1] = "châtaigne";
            Dico[2] = "groseille";
            Dico[3] = "pomme";
            Dico[4] = "tomate";

        }
            public String[] getWordList()
            {
                    return Dico;
            }
            
            
            
            public boolean isValidWord( String str)
            {
                   int i;
                   boolean found = false;
                   for (i = 0 ; i  <= nbWord    ; i ++)
                   {
                       
                       if (Dico[i].equals(str))
                       {
                           found = true;
                       }

                   }
                   return found;
            }
}
