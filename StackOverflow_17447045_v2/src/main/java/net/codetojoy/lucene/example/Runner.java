
package net.codetojoy.lucene.example;

import java.util.List;
import java.nio.file.*;

public class Runner {
    public void run(String filePath) throws Exception {
        String text = new String(Files.readAllBytes(Paths.get(filePath))); 

        KeywordsExtractor keywordsExtractor = new KeywordsExtractor();
        List<CardKeyword> keywords = keywordsExtractor.getKeywordsList(text);

        for (CardKeyword keyword : keywords) {
            StringBuilder buffer = new StringBuilder();
            buffer.append(keyword.getFrequency());
            buffer.append(" " + keyword.getStem());

            buffer.append(" [");
            for (String term : keyword.getTerms()) {
                buffer.append(term + " ");
            }
            buffer.append("]");

            System.out.println(buffer.toString());
        }
    }

    public static void main(String[] args) {
        try {
            String filePath = args[0];
            System.out.println("using filePath: " + filePath);

            new Runner().run(filePath);

            System.out.println("Ready.");
        } catch (Exception ex) {
            System.err.println("caught ex: " + ex.getMessage());
        }
    }
}
