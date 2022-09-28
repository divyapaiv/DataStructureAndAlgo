
/*https://www.hackerrank.com/challenges/beautiful-triplets/problem 
INPUT sorted array 
out count of pairs which are beautify 
1. i<j<k 
2. a[j]-a[i]==a[k]-a[j]
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
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
        int count=0;
        if(arr.size() <3)return 0; 
        
        for(int i=0;i<arr.size()-1;i++){
            for(int j=i+1;j<arr.size();j++){
              
                if(arr.get(j)-arr.get(i)==d){
                     
                     int k=find(arr.get(j)+d,arr,j+1,arr.size()-1);
                     System.out.println(arr.get(j)+d);
                     System.out.println(k);
                     if(k!=-1 && k>j)
                    {
                     count++;
                    }
                   
                }
                }
               
            }
        
        return(count);
        
    // Write your code here

    }
    public static int find(int key, List<Integer> arr,int low,int high) {
    int mid=0; 
     //System.out.println("H"+high);
    while(low<=high){
   
        mid=(int)((low+high)/2); 
        
        if(arr.get(mid)==key ) return key; 
        if(arr.get(mid)>key) high=mid-1; 
        if(arr.get(mid)<key) low=mid+1; 
    }
         System.out.println(low);
    //System.out.println("H2"+high);
     //System.out.println(mid);
    return -1;
    

}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
