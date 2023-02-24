//https://www.hackerrank.com/challenges/bigger-is-greater/problem?isFullScreen=true
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
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
    // Write your code here
    int maxpos=-1;
    for(int i=w.length()-1;i>0;i--){
        if(w.charAt(i)>w.charAt(i-1)){
            maxpos=i-1;
            break;
        }
    }
    
    if(maxpos==-1){
        return "no answer";
    }
    else{
        String s="";
        //s= swap(w,maxpos,w.length()-1);
        for(int i=w.length()-1;i>maxpos;i--){
             if(w.charAt(i)>w.charAt(maxpos)){
                 //System.out.println(w +" "+i+" "+maxpos);
                     s= swap(w,i,maxpos);
                     break;
                }
            }
        s=reverse(s,maxpos+1,w.length()-1);
         return s;
    }

    }
    public static String swap(String w,int i,int j) 
    {
        char [] str= w.toCharArray();
        char t=str[i];
        str[i]=str[j];
        str[j]=t;
        return new String(str);
    
    }
    public static String reverse(String w,int i,int j) 
    {
        char [] str= w.toCharArray();
        int low=i;
        int high=j; 
        while(low<high){
        char t=str[low];
        str[low]=str[high];
        str[high]=t;
        low++;
        high--;
        }
        return new String(str);
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

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
