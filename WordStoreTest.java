import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;
import java.io.IOException;


class WordStoreTest {
    public static void main(String [] args) throws IOException {
        BufferedReader reader = null;
        WordStore store = new WordStore();
        store.put("a", "Test1");
        store.put("a", "Test2");
        store.put("a", "Test3");

        System.out.println("The following has been randomly selected from store: " + store.getRandomWord("a"));

        try {
            WordStore nouns = new WordStore(new File("nouns.txt"));
            WordStore adjectives = new WordStore(new File("adjectives.txt"));
            WordStore adverbs = new WordStore(new File("adverbs.txt"));
            VerbStore verbs = new VerbStore(new File("verbs.txt"));

            System.out.println("The following word has been randomly selected from verbs: " + verbs.getRandomWord("b"));
            System.out.println("The following word has been randomly selected from nouns: " + nouns.getRandomWord("B"));
            System.out.println("The following word has been randomly selected from adjectives: " + adjectives.getRandomWord("B"));
            System.out.println("The following word has been randomly selected from adverbs: " + adverbs.getRandomWord("b"));


        }
        catch(IOException z) {
            z.printStackTrace();
        }
    }
}
