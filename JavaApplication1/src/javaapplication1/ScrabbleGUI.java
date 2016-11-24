package javaapplication1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class ScrabbleGUI implements ActionListener{

    private Dictionnary dico;
    private JTextField letterTextField;
    private JButton searchButton;
    private JTextArea wordListTextArea;
    private JPanel topPanel;
    private JPanel centerPanel;

    public ScrabbleGUI(){
        dico = new Dictionnary("./fr_FR_utf8.dico");

        JFrame frame = new JFrame("Scrabble GUI");
        frame.setMinimumSize(new Dimension(640,480));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout gridLayout = new GridLayout(2,1);
        frame.setLayout(gridLayout);

        topPanel = new JPanel();
        centerPanel = new JPanel();
        frame.add(topPanel);
        frame.add(centerPanel);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        topPanel.setLayout(flowLayout);
        letterTextField = new JTextField("                              ");
        searchButton = new JButton("Get Words");
        searchButton.addActionListener(this);
        topPanel.add(letterTextField);
        topPanel.add(searchButton);

        GridLayout gridLayout1 = new GridLayout(1,1);
        wordListTextArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(wordListTextArea);
        centerPanel.setLayout(gridLayout1);
        centerPanel.add(scroll);

        topPanel.setBorder(BorderFactory.createTitledBorder("Yours letters"));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Matching words"));

        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ev){


        String strLetters = letterTextField.getText();
        if (!strLetters.isEmpty()){
            wordListTextArea.setText("");
            char[] letters = strLetters.toCharArray();
            ScrabbleComparator sc1 = new ScrabbleComparator(letters);
            String[] wordsFound = dico.getWordsThatCanBeComposed(letters);
            if (wordsFound != null){
                Arrays.sort(wordsFound, sc1);
                for (String s : wordsFound){
                    if (s != null)
                        wordListTextArea.append("[-] " + s + " " + Arrays.toString(Dictionnary.getComposition(s, letters)) + " - " + sc1.wordValue(s) + " points\n");
                }
            }
            else {
                wordListTextArea.append("No words found...");
            }
            centerPanel.updateUI();

        }
    }

    public static void main(String args[]){
        new ScrabbleGUI();
    }
}
