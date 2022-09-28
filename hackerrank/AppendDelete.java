/*https://www.hackerrank.com/challenges/append-and-delete/problem?h_r=profile
You have two strings of lowercase English letters. You can perform two types of operations on the first string:

Append a lowercase English letter to the end of the string.
Delete the last character of the string. Performing this operation on an empty string results in an empty string.
Given an integer, , and two strings,  and , determine whether or not you can convert  to  by performing exactly  of the above operations on . If it's possible, print Yes. Otherwise, print No.
*/

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
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k)     {
    // Write your code here
      int s1_length=s.length(); 
      int s2_length=t.length(),i=0;
      int operations=0;
      if(k>(s1_length+s2_length)) return "Yes";
     for (i=0;i<Math.min(s1_length,s2_length);i++){
              System.out.println(s.charAt(i));
              System.out.println(t.charAt(i));
              if(s.charAt(i)==t.charAt(i)){
                  
                  continue;
              }
              else{
                
                 break;
              }
          }
                    operations= (s1_length-i)+s2_length-i;//}
    // System.out.println((operations));
     
        k-=operations;
      if(k%2==0 && k>=0){
          return "Yes"; 
      }
      else 
      {
          return "No"; 
      }
      

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
