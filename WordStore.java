  /**
* Author: Jason Jay Dookarun
* Student Number: 100877905
*
* Version: 0.1


* The following program has been designed to form a personalised acrostic
  unary poem. It takes a person's name as an input and forms a poem.


*/

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

public class WordStore {
    Map<String,List<String>> map;

    public WordStore() {
        map = new HashMap<String, List<String>>();
    }

    public WordStore(File file) throws IOException {
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

    public boolean containsKey(String key) {
        if (map.get(key)== null) {
        return false;
        }
        return true;
    }

    void put(String key, String word) {
        if (map.containsKey(key)){
            map.get(key).add(map.get(key).size(), word);
        }
        else {
            List<String> newList = new ArrayList<String>();
            newList.add(word);
            map.put(key,newList);
        }
    }

    public String getRandomWord (String key) {
        if (containsKey(key)) {
            Random r = new Random();
            return map.get(key).get(r.nextInt(map.get(key).size()));
        }
        else {
            return null;
        }
    }
}
