// The file name is not necessarily the same as the class name written in the code
//https://www.hackerrank.com/challenges/mini-max-sum/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.Collections;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        Long minSum = 0L;
        Long maxSum = 0L;
        
        List<Integer> crescList = new ArrayList<>();
        Collections.sort(arr);
        crescList = arr;
        
        for(int i = 0; i < 4; i++) {
            minSum += crescList.get(i);
        }
        
        List<Integer> descList = new ArrayList<>();
        Collections.reverse(arr);
        descList = arr;
        
        for(int i = 0; i < 4; i++) {
            maxSum += descList.get(i);
        }

        System.out.print(minSum);
        System.out.print(" ");
        System.out.print(maxSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

