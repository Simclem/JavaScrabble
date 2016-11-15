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
        String[] Dico;


        public Dictionnary()
        {
            Dico = new String[12];
            Dico[0] = "abricot";
            Dico[1] = "châtaigne";
            Dico[2] = "groseille";
            Dico[3] = "pomme";
            Dico[3] = "tomate";
            System.out.print(Dico[0] + "\n");
        }
            public String[] getWordList()
            {
                    return Dico;
            }
}
