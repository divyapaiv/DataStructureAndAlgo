//https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/max-circular-subarray-sum-1587115620
/*Given an array arr[] of N integers arranged in a circular fashion. Your task is to find the maximum contiguous subarray sum.
Algorithm 
1.Use Kadane's algorithm to find sum 
2. Invert array for eg: 
if array is 2 3 1 -5 -8 -9 -10  inverted array is -2 -3 -1 +5 +8 +9 +10 call kadane's algo again which will give minsum. 
add max sum of inverted sum to overallsum. For eg: if overallsum= -26 +32 = 6
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        int normal_sum=kadane(a,n),overallsum=0;
        if(normal_sum<0) return normal_sum;
        for(int i=0;i<n;i++){
            overallsum+=a[i];
            //reversing array element to get revert sum
            a[i]=-a[i];
        }
        return Integer.max(normal_sum,overallsum+kadane(a,n));
    
    }
    static int kadane(int a[], int n)
    {
        int i=0,maxsum=Integer.MIN_VALUE,cursum=0;
        for(i=0;i<n;i++){
            if(cursum<=0){
                cursum=a[i];
            }
            else{
                cursum+=a[i];
            }
            maxsum=Math.max(cursum,maxsum);
        }
        return(maxsum);
    }
 
    
    
}
