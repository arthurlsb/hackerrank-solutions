// The file name is not necessarily the same as the class name written in the code
// https://www.hackerrank.com/challenges/time-conversion
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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        if (s.contains("AM")) {
            if (s.charAt(0) == '1' && s.charAt(1) == '2') {
                s = changeCharInPosition(0, '0', s);
                s = changeCharInPosition(1, '0', s);
            }
        } else {
            if (!(s.charAt(0) == '1' && s.charAt(1) == '2')) {
                int value = Integer.parseInt(s.substring(0, 2));
                value += 12;
                String str = String.valueOf(value); 
                s = changeCharInPosition(0, str.charAt(0), s);
                s = changeCharInPosition(1, str.charAt(1), s);
            } 
        }
        
        s = s.substring(0, s.length() - 2);
        return s;
    }
    
    public static String changeCharInPosition(int position, char ch, String str){
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
