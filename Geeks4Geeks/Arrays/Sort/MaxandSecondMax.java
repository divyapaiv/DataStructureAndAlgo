//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here
https://practice.geeksforgeeks.org/batch/test-series-bundle/track/amazon-arrays/problem/max-and-second-max
Given an array arr[] of size N of positive integers which may have duplicates. The task is to find the maximum and second maximum from the array, 
and both of them should be different from each other, so If no second max exists, then the second max will be -1.

*/

import java.io.*;
import java.util.*;


// } Driver Code Ends
        


// Solution class to implement function largestAndSecondLargest
class Solution{
    
    // Function to find largest and second largest element in the array
    public static ArrayList<Integer> largestAndSecondLargest(int n, int a[])
    {
        //code here.
        int first_max=a[0];
        int second_max=-1;
         ArrayList<Integer> res=new  ArrayList<Integer>();
        for(int i=1;i<n;i++){
            if(a[i]>first_max){
                second_max=first_max;
                first_max=a[i];
                
                
            }
            else if(a[i]>second_max && a[i]!=first_max)
            {
                 second_max=a[i];
            }
        }
        res.add(first_max);
        res.add(second_max);
        return(res);
        
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    int arr[] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int index = 0;index < sizeOfArray; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.largestAndSecondLargest(sizeOfArray, arr);
		    System.out.println(res.get(0) + " " + res.get(1) );
		}
	}
}
// } Driver Code Ends
