//{ Driver Code Starts
/*
Given an array of distinct elements. Find the third largest element in it.

Suppose you have A[] = {1, 2, 3, 4, 5, 6, 7}, its output will be 5 because it is the 3 largest element in the array A.
Time Complexity : 
Best Case : N ( First pivot element is 3rd largest element) 
Worst Case : N log N as we need to sort everything 
*/
import java.util.Scanner;
import java.util.*;
import java.io.*;

class ThirdLargestElement
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n =sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution g = new Solution();
			System.out.println(g.thirdLargest(arr,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    
    
    int thirdLargest(int a[], int n)
    {
        if(n<3) return -1;
        return(quickselect(a,0,n-1,n));
        
        
	  
    }
    int quickselect(int a[],int beg,int end,int n){
        if(beg<=end){
            int p= partition(a,beg,end);
            if(p==2)
                return a[p];
            else if( p<2){
               return quickselect(a,p+1,end,n); }
            else 
              return quickselect(a,beg,p-1,n);
        }
        
        return -1;
    }
    int partition(int a[],int beg,int end){
        int i=beg;
        int key=a[end];
        for(int j=beg;j<end;j++){
            if(key<a[j]){
               int t=a[i];
                a[i]=a[j];
                a[j]=t;
                i++;
            }
    }
        // System.out.println("I"+i);
          int t=a[i];
          a[i]=a[end];
          a[end]=t;
        //  System.out.println(Arrays.toString(a));
            return(i);
            
        
      
        
        }
        
    
}
