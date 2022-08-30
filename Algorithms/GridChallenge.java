// The file name is not necessarily the same as the class name written in the code
// https://www.hackerrank.com/challenges/grid-challenge
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
    List<String> gridRearranged = new ArrayList<>();
        boolean result = true;
        
        //Ordenar o array original
        for (String row : grid) {
            char[] chars = row.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            gridRearranged.add(sorted);
        }
        
        String[] columns = new String[grid.size()];
        
        for(int i=0; i<grid.size(); i++) {
            columns[i] = "";
        }
        
        for (String str : gridRearranged) {
            for(int i=0; i<str.length(); i++) {
                columns[i] += str.charAt(i);
            }
        }
        
        for(int i=0; i<grid.size(); i++) {
            result = result & isAlphabeticOrder(columns[i]);
        }
        
        if (result) {
            return "YES";
        } else {
            return "NO";
        }

    }
    
    static boolean isAlphabeticOrder(String s) {
        int n = s.length();
        char c[] = new char [n];
        
        for (int i = 0; i < n; i++) {
            c[i] = s.charAt(i);
        }
        
        Arrays.sort(c);
        
        for (int i = 0; i < n; i++)
            if (c[i] != s.charAt(i)) 
                return false;
                
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
