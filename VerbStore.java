import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.lang.*;


public class VerbStore extends WordStore {

    public VerbStore(File file) throws IOException {
        BufferedReader reader = null;
        map = new HashMap<String,List<String>>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String word, key = "";
            while (reader.readLine()!=null){
                word = reader.readLine();
                put(word.substring(0,1),word);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
        reader.close();
        }
    }

    public String getRandomWord(String key) {
        if (this.containsKey(key)) {
            Random rand= new Random();
            String s = map.get(key).get(rand.nextInt(map.get(key).size()));
            if (s.charAt(s.length()-1)=='e') {
                String temp = s.substring(0,s.length()-1);
                temp = temp.concat("ing");
                return temp;
            }
            return s;
        }
        else return null;
    }
}