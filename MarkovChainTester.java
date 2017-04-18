// Try out the MarkovChain class.

import java.util.ArrayList;

public class MarkovChainTester {
    public static void main (String [] args) {

        // Get words from file

        String filename = "green-eggs.txt";
        ArrayList<String> words = new ArrayList<String>();
        words = FileTokenizer.tokenize(filename);

        MarkovChain mcFruits = new MarkovChain(2);

        // Make some ngrams
        String [] words1 = new String [] {"apple", "berry"};
        String [] words2 = new String [] {"berry", "cherry"};
        String [] words3 = new String [] {"cherry", "durian"};
        String [] words4 = new String [] {"durian", "eggplant"};

        NGram appleBerry = new NGram(2, words1);
        NGram berryCherry = new NGram(2, words2);
        NGram cherryDurian = new NGram(2, words3);
        NGram durianEggplant = new NGram(2, words4);

        appleBerry.addAdjacent(berryCherry);
        berryCherry.addAdjacent(cherryDurian);
        berryCherry.addAdjacent(appleBerry);
        cherryDurian.addAdjacent(durianEggplant);
        durianEggplant.addAdjacent(appleBerry);

        mcFruits.addNGram(appleBerry, null);
        mcFruits.addNGram(berryCherry, null);
        mcFruits.addNGram(cherryDurian, null);
        mcFruits.addNGram(durianEggplant, null);

        NGram existingFruitGram = mcFruits.findNGram(new String[] {"apple", "berry"});

        System.out.print(existingFruitGram.getNGram()[0] + ", ");
        System.out.println(existingFruitGram.getNGram()[1]);

        NGram nonExistantFruitGram = mcFruits.findNGram(new String[] {"cup", "cake"});
        System.out.println(nonExistantFruitGram);

        System.out.println("\nLet's add a node whose parent isn't set.\n------");

        NGram eggplantFig = new NGram(2, new String[] {"eggplant", "fig"});
        mcFruits.addNGram(eggplantFig, new String[] {"cherry", "durian"});

        for (NGram node : mcFruits.getNGrams()) {
            System.out.println("Node: " + node.getNGram()[0] + " " + node.getNGram()[1]);
            for (NGram adj : node.getAdjacent()) {
                System.out.println("Adj: " + adj.getNGram()[0] + " " + adj.getNGram()[1]);
            }
        }

        MarkovChain mcGreenEggs = new MarkovChain(2);

        mcGreenEggs.makeChains(words);

        for (NGram node : mcGreenEggs.getNGrams()) {
            System.out.println("Node: " + node.getNGram()[0] + " " + node.getNGram()[1]);
            for (NGram adj : node.getAdjacent()) {
                System.out.println("Adj: " + adj.getNGram()[0] + " " + adj.getNGram()[1]);
            }
            System.out.println("\n");
        }

    }
}
