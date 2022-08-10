// The file name is not necessarily the same as the class name written in the code
//https://www.hackerrank.com/challenges/plus-minus/problem
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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        	Double ratioPositiveValues = 0.0;
            Double ratioNegativeValues = 0.0;
            Double ratioZeroValues = 0.0;
            
            int size = arr.size();
            
            for (Integer value : arr) {
                if (value > 0) {
                    ratioPositiveValues++;
                } else if (value < 0) {
                    ratioNegativeValues++;
                } else {
                    ratioZeroValues++;
                }
            }
            
            ratioPositiveValues /= size;
            ratioNegativeValues /= size;
            ratioZeroValues /= size;
            
            System.out.format("%.6f \n", ratioPositiveValues);
            System.out.format("%.6f \n", ratioNegativeValues);
            System.out.format("%.6f \n", ratioZeroValues);
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

