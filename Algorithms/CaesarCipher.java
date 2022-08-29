// The file name is not necessarily the same as the class name written in the code
// https://www.hackerrank.com/challenges/caesar-cipher-1
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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        

        for (int i = 0; i < s.length(); i++) {
            if (alphabet.contains(s.charAt(i) + "")) {
                try {
                    char letter = alphabet.charAt(alphabet.indexOf(s.charAt(i))+k);
                    s = changeCharInPosition(i, letter, s);
                } catch (Exception e) {
                    char letter = alphabet.charAt((alphabet.indexOf(s.charAt(i)) + k) % 26);
                    s = changeCharInPosition(i, letter, s);
                }
            } else if (alphabetUpperCase.contains(s.charAt(i) + "")) {
                try {
                    char letter = alphabetUpperCase.charAt(alphabetUpperCase.indexOf(s.charAt(i)) + k);
                    s = changeCharInPosition(i, letter, s);
                } catch (Exception e) {
                    char letter = alphabetUpperCase.charAt((alphabetUpperCase.indexOf(s.charAt(i)) + k) % 26);
                    s = changeCharInPosition(i, letter, s);
                }
            }

        }

        return s;
    }

    public static String changeCharInPosition(int position, char ch, String str) {
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
