// Test drive the file tokenizer class.

import java.util.ArrayList;

public class FileTokenizerTester {
    public static void main(String[] args) {
        String filename = "green-eggs.txt";
        ArrayList<String> words = new ArrayList<String>();
        words = FileTokenizer.tokenize(filename);

        for (String word : words) {
            System.out.println(word);
        }

        System.out.println("-------------------------");

        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + " index: " + i);
        }

        System.out.println("-------------------------");

        for (int i = 0; i < words.size() - 1; i++) {
            System.out.println(words.get(i) + " " + words.get(i + 1));
        }
    } 
}
