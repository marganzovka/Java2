import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String inputString = getInput("input.txt");
        HashMap<String, Integer> map = counting(inputString);


        System.out.println(map);
        System.out.println("Самое длинное слово: " + theLongestWord(map));
        System.out.println("Cамое популярное: " + popularWord(map));


    }

    public static String popularWord(HashMap<String, Integer> map) {
        String maxKey = "";
        int maxValue = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }


        return maxKey;
    }

    public static String getInput(String filename){
        String inputString = "";
        try (FileReader reader = new FileReader(filename))
        {
            int c;
            while ((c = reader.read()) != -1) {
                inputString += (char)c;
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return  inputString;
    }

    public static HashMap<String, Integer> counting(String inputString ){
        List<String> productsList = new ArrayList<String>();
        productsList = List.of(inputString.trim().split(" "));

        HashMap<String, Integer> map = new HashMap<>();

        for (String product : productsList) {

            if (map.containsKey(product)){
                map.put(product, map.get(product) + 1);
            } else if (product.isEmpty());
            else {
                map.put(product, 1);
            }

        }
        return map;
    }

    public static String theLongestWord(HashMap<String, Integer> map){
        List<String> keys = new ArrayList<String>(map.keySet());
        List<Integer> sizeKeys = new ArrayList<Integer>();
        for(int i = 0; i < keys.size(); i++) {
            sizeKeys.add(keys.get(i).length());

        }

        int maxIndex = maxValue(sizeKeys);
        return keys.get(maxIndex);
    }

    public static Integer maxValue(List<Integer> values){
        int max = values.get(0);
        int maxIndex = 0;
        for (int i = 1; i < values.size() - 1; i++)
        {
            if(values.get(i) > max)
            {
                max = values.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

