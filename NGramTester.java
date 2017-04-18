import java.util.LinkedList;

public class NGramTester {
    public static void main (String [] args) {
        String [] words1 = new String [] {"apple", "berry"};
        String [] words2 = new String [] {"berry", "cherry"};
        String [] words3 = new String [] {"cherry", "durian"};
        String [] words4 = new String [] {"durian", "eggplant"};

        // Create circular fruit chain
        NGram appleBerry = new NGram(2, words1);
        NGram berryCherry = new NGram(2, words2);
        NGram cherryDurian = new NGram(2, words3);
        NGram durianEggplant = new NGram(2, words4);

        appleBerry.addAdjacent(berryCherry);
        berryCherry.addAdjacent(cherryDurian);
        cherryDurian.addAdjacent(durianEggplant);
        durianEggplant.addAdjacent(appleBerry);

        LinkedList<NGram> toVisit = new LinkedList<NGram>();

        toVisit.add(appleBerry);
        toVisit.add(berryCherry);
        toVisit.add(cherryDurian);
        toVisit.add(durianEggplant);

        while (toVisit.peek() != null) {
            NGram currentNGram = toVisit.remove();

            for (String word : currentNGram.getNGram()) {
                System.out.println(word);
            }
        }

    }
}