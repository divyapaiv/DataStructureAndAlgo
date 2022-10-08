/*
Given an array arr[] of N distinct integers, check if this array is Sorted (non-increasing or non-decreasing) and Rotated counter-clockwise. Note that input array may be sorted in either increasing or decreasing order, then rotated.
A sorted array is not considered as sorted and rotated, i.e., there should be at least one rotation.
*/
//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


// } Driver Code Ends

class Solution{    
    
    // arr[]: input array
    // num: size of array
    // Function to check if array is sorted and rotated
    public static boolean checkRotatedAndSorted(int a[], int n){
        
        // Your code here
       int i=0,minpos=0,maxpos=0,asc=0,desc=0;
       /*if N<=2 the array will be sorted and rotation will have no impact*/
       if(n<=2) return false;
       for(i=0;i<n;i++){
           if(a[minpos]>a[i]){
               minpos=i;
           }
           if(a[maxpos]<a[i]){
               maxpos=i;
           }
       }
        /*if minpos and maxpos are of sorted array return false*/
       if(minpos==0 && maxpos==n-1) return false;
       /*see if all elements are sorted in asc*/
       for( i=minpos;i<n+minpos-1;i++){
           if(a[i%n]<a[(i+1)%n]) asc++;
       }
      
       if(asc==n-1 ) return true; 
     //  System.out.println(minpos);
       /*see if all elements are sorted in desc*/
       for( i=maxpos;i<n+maxpos-1;i++){
           if(a[i%n]>a[((i+1)%n)]) desc++;
       }
     //  System.out.println(desc);
       if(desc==n-1) return true; 
      return false;
        
    }
    
}

//{ Driver Code Starts.

class Main {
    
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); // input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split("\\s+");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		   
		 Solution obj = new Solution();
        
        if(!(obj.checkRotatedAndSorted(arr, n)))
            System.out.println("No"); // print the result
        else
            System.out.println("Yes");
		}
	}
}

// } Driver Code Ends
