// A graph representing the Markov chain breakdown of a corpus of text.
// TODO: Make a graph class for this to inherit from...

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class MarkovChain {
    // ngrams in this chain
    private ArrayList<NGram> nGrams = new ArrayList<NGram>();
    private int nGramLength;

    // constructor
    public MarkovChain(int n) {
        nGramLength = n;
    }

    // getter method for ngram list
    public ArrayList<NGram> getNGrams() {
        return nGrams;
    }

    // add new ngram to chain, and update preceeding ngram node's adjacency list

    public void addNGram(NGram nGram, String[] parentNGramWords) {
        if (parentNGramWords != null) {
            NGram parent = findNGram(parentNGramWords);

            if (parent != null) {
                parent.addAdjacent(nGram);
            }
        }

        nGrams.add(nGram);
        System.out.println("adding ngram to chain");
    }

    public NGram findNGram(String[] words) {

        // Track nodes to visit, and because graphs may have cycles, track seen

        LinkedList<NGram> toVisit = new LinkedList<NGram>();
        ArrayList<NGram> seen = new ArrayList<NGram>();

        toVisit.add(nGrams.get(0));
        System.out.println("\nLooking for node...\n----------");

        while (toVisit.peek() != null) {
            // fetch next node to look at
            NGram currentNGram = toVisit.remove();
            seen.add(currentNGram);

            System.out.print(currentNGram.getNGram()[0] + ", ");
            System.out.println(currentNGram.getNGram()[1]);

            // Is it the node we want?

            if (Arrays.equals(currentNGram.getNGram(), words)) {
                System.out.println("they're equal");
                return currentNGram;
            }

            // If not, add its adjacency list to the nodes to visit.

            for (NGram nGram : currentNGram.getAdjacent()) {
                if (!seen.contains(nGram)) {
                    System.out.println("adding new nodes to visit...");
                    toVisit.add(nGram);
                }

                else {
                    System.out.println("Hey I've seen that one before! Skip.");
                }
            }
        }

        // If we get through the whole graph and haven't returned a node,
        // it wasn't there.

        System.out.println("Well crap, we didn't find it.");
        return null;
    }

    // Turn a list of words into a real set of Markov chains!

    public void makeChains(ArrayList<String> words) {
        String[] firstPair = new String [] {words.get(0), words.get(1)};
        NGram firstNGram = new NGram(2, firstPair);
        addNGram(firstNGram, null);

        for (int i = 1; i < words.size() - 1; i++) {
            String[] parentPair = new String[] {words.get(i-1), words.get(i)};

            String[] newPair = new String[] {words.get(i), words.get(i + 1)};
            NGram newNGram = new NGram(2, newPair);

            addNGram(newNGram, parentPair);
        }
    }

}
