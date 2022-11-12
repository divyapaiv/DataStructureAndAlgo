//https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Searching/problem/count-only-repeated2047
//{ Driver Code Starts
//Initial Template for Java
/*Given an array arr[] of N positive integers, where elements are consecutive (sorted). Also, there is a single element which is repeating X (any variable) number of times. Now, the task is to find the element which is repeated and number of times it is repeated.
Note: If there's no repeating element, Return {-1,-1}*/.
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.awt.Point; 
import java.util.Arrays; 
import java.util.Vector; 
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    Integer arr[] = new Integer[n];
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    Point p=new Solution().findRepeating(arr,n);
            
            System.out.println(p.x +" "+ p.y ); 
		    
		}
		
		
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find repeated element and its frequency.
    public static Point findRepeating(Integer a[],int n)
    {
       int h=n-1,l=0; 
       while(h>l){
           int mid=(h+l)/2; 
           //If first_ele + pos <= current mid element we can safely go to next half.
           if(a[0]+mid<=a[mid]){
               l=mid+1;
           }
           else{
              //If else stick to the first half
               h=mid; 
           }
       }
       
      int count=n-(a[n-1]-a[0]);
      if(a[0]+n-1<=a[n-1])
          return new Point(-1,-1);
      else   
        return new Point(a[l],count);
       
       
    }

};
