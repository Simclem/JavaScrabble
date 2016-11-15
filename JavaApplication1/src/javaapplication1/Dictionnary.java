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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Paths;
import java.util.List;
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
            nbWord = 12; 
            Dico = new String[nbWord];
            Dico[0] = "abricot";
            Dico[1] = "châtaigne";
            Dico[2] = "groseille";
            Dico[3] = "pomme";
            Dico[4] = "tomate";

        }
        public Dictionnary(String PathGiven)
        {
                int i = 0;
                List<String> Lines = null;
                Path pathFile = Paths.get(PathGiven);
                try
                {
                    Lines = Files.readAllLines(pathFile);

                }catch (IOException  e)
                {
                    System.out.println("Fichier introuvable");

                 }
                
                
                   nbWord = Integer.parseInt(Lines.get(0));
                    Dico = new String[nbWord];
                    
                    for (i = 0; i <nbWord ; i++)
                    {
                        Dico[i] = Lines.get(i+1);
                    }
        }
        
        
        
            public String[] getWordList()
            {
                    int i  = 0 ;

                    return Dico;
            }
            
            
            public void printDictionnary()
            {
                    int i ;
                     for (i = 0 ; i < nbWord; i++)
                    {
                        System.out.println(Dico[i] + "\n");
                    }
            }
            
            
            
            public boolean isValidWord( String str)
            {
                   int i;
                   boolean found = false;
                   for (i = 0 ; i  < nbWord    ; i ++)
                   {
                       
                       if (Dico[i].equals(str))
                       {
                           found = true;
                       }

                   }
                   return found;
            }
}
