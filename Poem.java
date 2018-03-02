import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

class Poem {
    
    public static void main(String[] args) {     
        Scanner s = new Scanner(System.in);
        System.out.println("Enter string: ");
        List<String> list = compose(s.next());
        System.out.println("\n");
        for (int i=0;i<=list.size()-1;i++) {
            System.out.println(list.get(i));
        }
    }
    
    public static List<String> compose(String input) {
        List<String> l = new ArrayList<String>();
        int start = 0;
      try {
        WordStore nouns = new WordStore(new File("nouns.txt"));
        WordStore adjectives = new WordStore(new File("adjectives.txt"));
        WordStore adverbs = new WordStore(new File("adverbs.txt"));
        WordStore verbs = new VerbStore(new File("verbs.txt"));
        if (input.length()%2 == 1) {
            l.add(adverbs.getRandomWord(String.valueOf(input.charAt(0))));
            start++;
        }
        for (int i= 0+start;i<input.length()-2-start;i=i+2) {
            l.add(adverbs.getRandomWord(String.valueOf(input.charAt(i))));
            l.add(verbs.getRandomWord(String.valueOf(input.charAt(i+1))));
        }
        l.add(adjectives.getRandomWord(String.valueOf(input.charAt(input.length()-2))));
        l.add(nouns.getRandomWord(String.valueOf(input.charAt(input.length()-1))));

      } catch(IOException z) {
        z.printStackTrace();
      }
      return l;
    }
}