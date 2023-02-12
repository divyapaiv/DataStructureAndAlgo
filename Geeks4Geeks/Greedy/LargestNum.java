//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		
	    while(t-- >0)
	    {
	        String inputLine[] = br.readLine().trim().split(" ");
	        
	        //taking n and sum
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);
            
            //calling largestNumber() function
            System.out.println(new Solution().largestNumber(n, sum));
	    }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum)
    {
        // add your code here
         String s="";
         int cursum=0;
         if(n<0  ) return "-1";
         if(n==1){
             if(n==sum) return Integer.toString(n);
         }
         if(9*n<sum){

            return "-1";

        }
         for(int i=0;i<n;i++){
             if(sum==0){
               s=s+"0";  
             }
             else if(sum>9){
                 s=s+"9";
                 sum=sum-9;
             }
             else{
                 s=s+Integer.toString(sum);
                 sum=0;
                
             }
             
         }
         if(sum>0) return "-1";
         return s;
        
    }
}


