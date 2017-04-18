// Tokenize a text file into a list of words.

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class FileTokenizer {

    public static ArrayList<String> tokenize(String filename) {
        ArrayList<String> tokens = new ArrayList<String>();
        try {
            File textFile = new File(filename);
            Scanner sc = new Scanner(textFile);

            while(sc.hasNext()) {
                tokens.add(sc.next());
            }
        }

        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return tokens;
        
    }
}
