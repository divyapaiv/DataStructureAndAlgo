/*
Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inverseMerge(long arr[],long l, long h){
        long result=0;
        long mid;
        
        if(l<h){
           
            mid=l+(h-l)/2;
           // l=mid+1;
           // h=h;
           result+=inverseMerge(arr,l,mid);
          // if(l== h || l>h) { System.out.println("DP1 "+l +" "+h); break;}
            result+=inverseMerge(arr,mid+1,h);
            result+=MergeArray(arr,l,mid,h);
        }
        return result;
    }
    static long MergeArray(long arr[],long l, long mid,long h){
        long n1=mid+1-l; 
        long n2=h-mid;
        long []A=new long[(int)n1];
        long []B=new long[(int)n2];
        int j=0;
        long res=0;
        for(int i=0;i<n1;i++){
            A[i]=arr[(int)l+i];
        }
        j=0;
        for(int i=0;i<n2;i++){
            B[i]=arr[(int)mid+i+1];
        }
        j=(int)l;
        int m=0; int k=0;
        while(m<n1 && k<n2){
            if(A[m]<=B[k]){
                arr[j] = A[m];
                j++;
                m++;
            }
            else
            {
                arr[j] = B[k];
                res+=n1-m;
                j++;
                k++;
                
            }
            
        }
        while(m<n1){
            arr[j] = A[m];
                j++;
                m++;
        }
        while( k<n2){
           arr[j] = B[k];
                res+=n1-m;
                j++;
                k++;
        }
      //System.out.println(Arrays.toString(A));
       // System.out.println(Arrays.toString(B));
       // System.out.println(Arrays.toString(arr));
        return res;
        
    }
    static long inversionCount(long arr[], long N)
    {
        //System.out.println("DP "+0 +" "+N);
        return(inverseMerge(arr,0,N-1));
    }
}
