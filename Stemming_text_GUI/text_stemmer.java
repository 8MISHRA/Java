// This assignment is about stemming the words in a text. It takes the input as text and shows the root word. Uses swing for the GUI.
// SUbmitted By: DIvyansh Mishra
// Submission Date: 05-02-2024

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class text_stemmer {
    public static void main(String[] args) {
        Stem st = new Stem();
    }
}


class Stem extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Get the stem words");
    JButton b = new JButton("stem it");
    JTextArea input, output;
    JLabel l1, l2;

    public Stem(){
        stamer stm = new stamer();
        HashMap<String, String> hashMap = new HashMap<>();

        l1 = new JLabel("Enter the text here");
        // l1.setBackground();
        l1.setBounds(80, 60, 180, 20);

        l2 = new JLabel("Result will be shown here:- ");
        // l1.setBackground();
        l2.setBounds(80, 450, 180, 20);

        b.setBounds(300, 375, 200, 50);

        input = new JTextArea();
        input.setBounds(100, 100, 600, 260);

        output = new JTextArea();
        output.setBounds(80,475,600,260);        

        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String intext = input.getText();

                String[] docs = intext.split(" ");
                ArrayList<String> words = new ArrayList<>(); 

                for(String word : docs){
                    if (word.trim().length()>3){
                        words.add(word.trim());
                    }
                }

                for (String word : words){
                    String value = stm.stem_it(word);
                    if (!(value.equals(word) | hashMap.containsKey(word))){
                        hashMap.put(word, value);
                    }
                }

                String wordout = "";
                for (HashMap.Entry<String, String> entry : hashMap.entrySet()){
                    wordout += entry.getKey() + ": " + entry.getValue()+ "\n";
                }

                output.setText(wordout);
            }

        });


        input.setLineWrap(true);
        input.setWrapStyleWord(true);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);    

        frame.add(l1);
        frame.add(input); 
        frame.add(b); 
        frame.add(l2); 
        frame.add(output);

        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae){
    }
}


class stamer {
    public String stem_it(String wordin) {
        // Create an instance of the Stemmer class
        Stemmer_word stemmer = new Stemmer_word();
        String word = wordin;

        String suffix = "";
        // Use a series of if-else statements to check the word for the suffix and assign the suffix variable accordingly
        if (word.endsWith("ed")) {
            suffix = "ed";
        } else if (word.endsWith("ly")) {
            suffix = "ly";
        } else if (word.endsWith("ful")) {
            suffix = "ful";
        } else if (word.endsWith("est")) {
            suffix = "est";
        } else if (word.endsWith("ity")){
            suffix  = "ity";
        }
        else if (word.endsWith("ant")){
            suffix  = "ant";
        }
        else if (word.endsWith("ness")){
            suffix  = "ness";
        }
        else if (word.endsWith("es")){
            suffix  = "es";
        }
        else if (word.endsWith("ic")){
            suffix  = "ic";
        }
        else if (word.endsWith("er")){
            suffix  = "er";
        }
        else if (word.endsWith("ing")){
            suffix  = "ing";
        }
        else if (word.endsWith("s")){
            suffix  = "s";
        }
        
        else {
            return word;
        }
        // Declare a variable to store the stemmed word
        String stemmedWord = "";
        // Use a switch statement to choose the appropriate method to call based on the suffix
        switch (suffix) {
            case "ed":
                stemmedWord = stemmer.stemEd(word);
                break;
            case "ly":
                stemmedWord = stemmer.stemLy(word);
                break;
            case "ful":
                stemmedWord = stemmer.stemFul(word);
                break;
            case "est":
                stemmedWord = stemmer.stemEst(word);
                break;
            case "ity":
                stemmedWord = stemmer.stemIty(word);
                break;

            case "ant":
                stemmedWord = stemmer.stemIty(word);
                break;
            case "ness":
                stemmedWord = stemmer.stemNess(word);
                break;

            case "es":
                stemmedWord = stemmer.stemEs(word);
                break;

            case "ic":
                stemmedWord = stemmer.stemIc(word);
                break;

            case "er":
                stemmedWord = stemmer.stemEr(word);
                break;

            case "ing":
                stemmedWord = stemmer.stemIng(word);
                break;
            case "s":
                stemmedWord = stemmer.stemS(word);
                break;

            default:
                return word;
        }
        return stemmedWord;
    }
}


class Stemmer_word {
    public String stemEd(String word) {
        if (word.length() >= 6 && word.endsWith("ceed")) {
            return word.substring(0, word.length() - 3) + "ess";
        }
        // If word length is greater than or equal to 6 and the word ends with eed, remove d from last
        if (word.length() >= 6 && word.endsWith("eed")) {
            return word.substring(0, word.length() - 1);
        }

        if (word.length() >= 6 && word.endsWith("ied")) {
            return word.substring(0, word.length() - 3) + "y";
        }

        if (word.length() >= 5 && word.endsWith("ered")) {
            return word.substring(0, word.length() - 2);
        }

        // If word length is greater than or equal to 5 and the word ends with vowel + red or ted, remove d from last
        if (word.length() >= 5 && word.matches(".[aeiou]red$|.[aeiou]ted$|.*[aeiou]zed$")) {
            return word.substring(0, word.length() - 1);
        }

        // If word length is greater than or equal to 6 and the word ends with ed, remove ed from last
        if (word.length() >= 6 && word.endsWith("ed")) {
            return word.substring(0, word.length() - 2);
        }

        return word;
    }

    public String stemLy(String word) {
        // If the word length is greater than or equal to 5, apply the rules
        if (word.length() >= 5) {
            // If the word ends with aly, remove y from the end
            if (word.endsWith("aly")) {
                return word.substring(0, word.length() - 1);
            }

            // If the word ends with ily, remove ily from the end and add y
            if (word.endsWith("ily")) {
                return word.substring(0, word.length() - 3) + "y";
            }

            // If the word ends with ly, remove ly from the end
            if (word.endsWith("ly")) {
                return word.substring(0, word.length() - 2);
            }
        }

        return word;
    }

    public String stemFul(String word) {
        // If the word ends with iful, remove iful from the end and add y
        if (word.length() >= 6 && word.endsWith("iful")) {
            return word.substring(0, word.length() - 4) + "y";
        }

        // If the word ends with full, remove ful from the end
        if (word.length() >= 6 && word.endsWith("ful")) {
            return word.substring(0, word.length() - 3);
        }

        return word;
    }

        public String stemEst(String word) {
        // If the word length is greater than or equal to 6, apply the rules
        if (word.length() >= 6) {
            // If the word ends with iest, remove iest from the end and add y
            if (word.endsWith("iest")) {
                return word.substring(0, word.length() - 4) + "y";
            }

            // If the word ends with llest, remove lest from the end and add l
            if (word.endsWith("llest")) {
                return word.substring(0, word.length() - 4);
            }

            // If the word ends with est, remove est from the end
            if (word.endsWith("est")) {
                return word.substring(0, word.length() - 3);
            }
        }
        return word;

        
    }

public String stemIty(String word) {
        // Check if the word length is 7 or more
        if (word.length() >= 7) {
            // Check if the word ends with ity
            if (word.endsWith("ity")) {
                // Check if the word ends with ility
                if (word.endsWith("ility")) {
                    // Remove ility and add le
                    return word.substring(0, word.length() - 5) + "le";
                }
                // Check if the word ends with vity
                else if (word.endsWith("vity")) {
                    // Remove ity and add e
                    return word.substring(0, word.length() - 3) + "e";
                }
                else if (word.endsWith("nity")) {
                    // Remove ity and add e
                    return word.substring(0, word.length() - 3) + "e";
                }
                // Otherwise, remove ity
                else {
                    return word.substring(0, word.length() - 3);
                }
            }
            // If the word does not end with ity, return the original word
            else {
                return word;
            }
        }
        // If the word length is less than 7, return the original word
        else {
            return word;
        }
    }


    public String stemNess(String word) {
    if (word.length() >= 5) {
        if (word.endsWith("iness")){
            word = word.substring(0, word.length() - 5) + "y";
        } else if (word.endsWith("ness")) {
            word = word.substring(0, word.length() - 4);
        }
    }
    return word;

    }

public String stemEs(String word) {
        // Check if the word ends with es
        if (word.endsWith("es")) {
            // Check if the word ends with ies
            if (word.endsWith("ies")) {
                // Check if the word length is 8 or more
                if (word.length() >= 8) {
                    // Remove ies and add y
                    return word.substring(0, word.length() - 3) + "y";
                }
                // If the word length is less than 8, return the original word
                else {
                    return word;
                }
            }
            // Check if the word ends with vowel+consonant+es
            else if (word.matches(".*[aeiou][^aeiou]es$")) {
                // Remove s
                return word.substring(0, word.length() - 1);
            }
            // Check if the word ends with ves
            else if (word.endsWith("ves")) {
                // Remove ves and add f
                return word.substring(0, word.length() - 3) + "f";
            }
            // Otherwise, remove es
            else {
                return word.substring(0, word.length() - 2);
            }
        }
        // If the word does not end with es, return the original word
        else {
            return word;
        }
    }


    public String stemEr(String word) {
        
        // If the word length is greater than or equal to 5 and the word ends with "ier", replace "ier" with "y"
        if (word.length() >= 5 && word.endsWith("ier")) {
            return word.substring(0, word.length() - 3) + "y";
        }

        // If the word length is greater than or equal to 7 and the word ends with "izer", remove "er" from the end
        if (word.length() >= 7 && word.endsWith("izer")) {
            return word.substring(0, word.length() - 1);
        }
        // If the word length is greater than or equal to 4 and the word ends with "er", remove "er" from the end
        if (word.length() >= 4 && word.endsWith("er")) {
            return word.substring(0, word.length() - 2);
        }
        // Return the original word if it doesn't match any of the rules
        return word;
    }

    public String stemIc(String word) {
        // If the word length is greater than or equal to 6 and the word ends with "gic" or "mic", replace "ic" with "y"
        if (word.length() >= 6 && (word.endsWith("gic") || word.endsWith("mic"))) {
            return word.substring(0, word.length() - 2) + "y";
        }

        // If the word length is greater than or equal to 5 and the word ends with "atic", remove "ic" from the end
        if (word.length() >= 5 && word.endsWith("atic")) {
            return word.substring(0, word.length() - 2 )+ "e";
        }
        // If the word length is greater than or equal to 6 and the word ends with "ic", remove "ic" from the end
        if (word.length() >= 6 && word.endsWith("ic")) {
            return word.substring(0, word.length() - 2);
        }
        // Return the original word if it doesn't match any of the rules
        return word;
    }

    /**
     * Stems words ending with "ing" based on specified rules.
     * 
     * @param word The input word to be stemmed.
     * @return The stemmed word.
     */
    public String stemIng(String word) {

        if (word.length() >= 5 && (word.endsWith("nning") || word.endsWith("mming") || word.endsWith("pping") || word.endsWith("gging"))) {
            return word.substring(0, word.length() - 4);
        }

        // If the word length is greater than or equal to 5 and the word ends with "ling" or "gging", replace "ling" with "le"
        if (word.length() >= 5 && (word.endsWith("ling") || word.endsWith("gging"))) {
            return word.substring(0, word.length() - 3) + "e";
        }
        // If the word length is greater than or equal to 6 and the word ends with "izing", replace "izing" with "ize"
        if (word.length() >= 6 && word.endsWith("izing")) {
            return word.substring(0, word.length() - 3) + "e";
        }

        // If the word length is greater than or equal to 5 and the word ends with "ating", replace "ating" with "ate"
        if (word.length() >= 5 && word.endsWith("ating")) {
            return word.substring(0, word.length() - 3) + "e";
        }

        // If the word length is greater than or equal to 3 and the word ends with "ing", remove "ing" from the end
        if (word.length() >= 3 && word.endsWith("ing")) {
            return word.substring(0, word.length() - 3);
        }

        // If the word length is greater than or equal to 4 and the word ends with "ying", replace "ying" with "y"
        if (word.length() >= 4 && word.endsWith("ying")) {
            return word.substring(0, word.length() - 3) + "y";
        }

        // Return the original word if it doesn't match any of the rules
        return word;
    }

    public String stemS(String word){

        if (word.endsWith("ss")){
            return word = word.substring(0, word.length());
        }
        if (word.endsWith("s")){
            return word = word.substring(0, word.length()-1);
        }
        
        return word;
    }
}
