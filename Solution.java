package balancedBrackets;

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
    public static String isBalanced(String s) {
        int length = s.length();
        int openBracketCounter = 0;
        int closeBracketCounter = 0;
        int openParenthesesCounter = 0;
        int closeParenthesesCounter = 0;
        int openbraceCounter = 0;
        int closebraceCounter = 0;
        if(s.charAt(0) == ']' || s.charAt(0) == ')' || s.charAt(0) == '}') {
            return "NO";
        }
        else if(s.charAt(length - 1) == '[' || s.charAt(length-1) == '(' || s.charAt(length-1) == '{') {
            return "NO";
        }
        else {
            for(int i = 0; i< length; i++) {
                switch (s.charAt(i)) {
                    case '[':
                        openBracketCounter++;
                        if((s.charAt(i+1) == '}') || (s.charAt(i+1) == ')')) return "NO";
                        break;
                    case '{':
                        openbraceCounter++;
                        if((s.charAt(i+1) == ']') || (s.charAt(i+1) == ')')) return "NO";
                        break;
                    case '(':
                        openParenthesesCounter++;
                        if((s.charAt(i+1) == '}') || (s.charAt(i+1) == ']')) return "NO";
                        break;
                    case ']':
                        closeBracketCounter++;
                        break;
                    case '}':
                        closebraceCounter++;
                        break;
                    case ')':
                        closeParenthesesCounter++;
                        break;
                    default:
                        break;
                }

                if((closeBracketCounter > openBracketCounter) || (closeParenthesesCounter> openParenthesesCounter) || (closebraceCounter > openbraceCounter)) {
                    return "NO";
                }
            }
            return "YES";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

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
