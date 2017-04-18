// A node in a Markov chain graph.
// Contains an ngram and a list of nodes that follow the ngram.

import java.util.ArrayList;

public class NGram {

    // Data: ['Word1', 'Word2', ..., 'WordN']
    private String[] nGram;

    // Adjacency list: [<Node 'Word1', 'Word2'>, <Node 'WordX', 'WordY'>]
    private ArrayList<NGram> adjacent = new ArrayList<NGram>();

    private Integer nGramLength;

    public NGram(Integer n, String[] words) {

        if (words.length == n) {
            nGramLength = n;
            nGram = words;
        }

        else {
            System.out.println("Ngram length and num words don't match.");
        }
    }

    public Integer getNGramLength() {
        return nGramLength;
    }

    // Get the node at the passed index.

    public String[] getNGram() {
        return nGram;
    }

    public ArrayList<NGram> getAdjacent() {
        return adjacent;
    }

    public void addAdjacent(NGram newNGram) {
        adjacent.add(newNGram);
    } 
}
