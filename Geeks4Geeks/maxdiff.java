//{ Driver Code Starts
/*Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] < A[j] and i < j.*/

import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int N) { 
        int i=0,j=N-1,globalmax=0;
        int []leftmin=new int[N];
        int []rightmax=new int[N];
        leftmin[0]=a[0];
        rightmax[N-1]=a[N-1];
        for(i=1,j=N-2;i<N && j>=0;i++,j--){
            if(a[i]<leftmin[i-1]){
                leftmin[i]=a[i];
            }
            else
            {
                leftmin[i]=leftmin[i-1];
            }
            
            if(a[j]>rightmax[j+1]){
                rightmax[j]=a[j];
            }
            else
            {
                rightmax[j]=rightmax[j+1];
            }
        }
     i=0;
     j=0;
     /* I/P 31 30 8 1 89 4 5 10
     leftmin= 31 30 8 1 1 1 1 1 
     rightmin= 89 89 89 89 89 10 10 10
     31<89 diff=0;  j++;
     31<89 diff=1;  j++;
     31<89 diff=2;  j++;
     31<89 diff=3;  j++;
     31<89 diff=4;  j++; maxdiff=4
     31<10 false; i++; maxdiff=4
     30<10 false
     8<10 diff=3(6-3); j++;
      8<10 diff=4(7-3); j++;
      8<10 diff=5(8-3); j++;maxdiff=5;
     
     */
     while(i<N && j<N){
         if(leftmin[i]<=rightmax[j]){
             globalmax=Math.max(globalmax,(j-i));
             j++;
         }
         else{
         i++;
         }
         
     }
     return(globalmax);
        
    }
}



