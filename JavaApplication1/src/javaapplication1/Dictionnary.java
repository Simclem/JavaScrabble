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
            
            public void printNbWord()
            {
                System.out.println(this.nbWord);
            }
            
            
            public void displayExo10()
            {
                if (nbWord > 1)
                {
                        System.out.println(this.nbWord + " words loaded. From " + Dico[0] + " to " + Dico[nbWord -1]);
                }
                else
                {
                    if (nbWord == 1)
                    {
                        System.out.println("Only one word found : " + Dico[0] );
                    }
                    else
                    {
                        System.out.println("0 word founded. Sorry, the dictionnary is empty or the file was not founded");
                    }
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
            
            public static String replaceFrenchCharacter(String S)
            {
                int nbcharoe = 0 ;
                int nbcharae = 0 ;
                S = S.replace('à', 'a');
                S = S.replace('â', 'a');
                S = S.replace('ä', 'a');
                S = S.replace('ç', 'c');
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
                for (int i =  0 ; i < S.length(); i ++)
                {
                    if (S.charAt(i) == 'œ')
                    {
                        nbcharoe+=1;
                    }
                    if (S.charAt(i) == 'æ')
                    {
                        nbcharae+=1;
                    }
                }
                
                if ((nbcharoe == 0) && (nbcharae  == 0 ))
                {
                    return S;
                }
                else
                {
                    String newS = new String();
                    for (int i = 0 ; i < S.length(); i ++)
                    {
                        if (S.charAt(i) == 'æ')
                       {
                           newS += 'a';
                           newS+='e';
                       }
                        else
                        {
                            if (S.charAt(i) == 'œ')
                            {
                                newS+='o';
                                newS+='e';
                            }
                            else
                            {
                                newS+=S.charAt(i);
                            }
                        }
                    }
                    return newS;
                }
                
                

            }
            
            /* public String[] getWordsThatCanBeComposed(char [] letters)
            {
                 
            }
            */
            
            public boolean mayBeComposed(String word, char[] letters)
            {
                int i ;
                int y;
                int cptLetters;
                char wordComponent [] = word.toCharArray();
                for ( i = 0 ; i < wordComponent.length; i ++)
                {
                    cptLetters = 0;
                    for (y=0; y < letters.length; y ++)
                    {
                        if(Character.toUpperCase(wordComponent[i]) == Character.toUpperCase(letters[y]))
                        {
                            cptLetters +=1;
                        }
                        
                    }
                    if (cptLetters == 0 )
                    {
                        System.out.println("The caracter : " + wordComponent[i]+ " was not found.");
                        return false;
                    }
                }
                return true;
            }
            
            
            
}
