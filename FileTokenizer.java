// Tokenize a text file into a list of words.

import java.util.Scanner;
import java.io.*;

public class FileTokenizer {

    public static void main (String[] args) {
        try {
            File textFile = new File("green-eggs.txt");
            Scanner sc = new Scanner(textFile);

            while(sc.hasNext()) {
                System.out.println(sc.next());
            }
            
        }

        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
