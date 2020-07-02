import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */


public class LinesProcMap {
    public static Map<String, Integer> processData(ArrayList<String> array) {
        /*
         * Modify this method to process `array` as indicated
         * in the question. At the end, return a Map containing
         * the appropriate values
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        //code map array to list of Constituency
        Map<String,Map.Entry<Integer, Integer>> map = new HashMap<>();
        String[] values = new String[4];
        for (String str:array) {
            values = str.split(",");
            for (int i=0;i<4;i++) {
                values[i] = values[i].trim();
            }
            if (null == map.get(values[2]) || map.get(values[2].trim()).getKey() < Integer.valueOf(values[3])) {
                    map.put(values[2], new AbstractMap.SimpleEntry(Integer.valueOf(values[3]),Integer.valueOf(values[0])));
            }
        }
        Map<String, Integer> retVal = new HashMap<>();
        for (String str: map.keySet()) {
            retVal.put(str,map.get(str).getValue());
        }
        return (retVal);
    }


    public static void main(String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\pldt\\CODE\\Demo\\src\\com\\company\\input.txt")));
            while (in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String, Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("C:\\pldt\\CODE\\Demo\\src\\com\\company\\output.txt")));
            for (Map.Entry<String, Integer> e : retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
