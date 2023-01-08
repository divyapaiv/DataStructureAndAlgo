//{ Driver Code Starts
/*
Sliding window technique 
Cursum=PrevSum-(Sumofallelements-firstele)+(firstele*(N-1)); 
Given an array(0-based indexing), you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. 
The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.
Input:
N = 4
A[] = {8,3,1,2}
Output: 29
Explanation: Above the configuration
possible by rotating elements are
3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11
Here the max sum is 29 
*/
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}

// } Driver Code Ends


class GfG
{
    int max_sum(int A[], int n)
    {
	// Your code here
	int j=1;
	
	int initial_ele=A[0];
	int normalsum=0; 
	int maxsum=0;
	//3+1+2+8= 11
	//1+4+24=29
	//29-11+9=27
  
	for(int i=0;i<n;i++){
	    normalsum+=A[i];
	    maxsum+=i*A[i];
	}
	int prevsum=maxsum;
	int cursum=0;
    for(int i=1;i<n;i++){
	    cursum=prevsum-(normalsum-A[i-1])+(A[i-1]*(n-1));
	  /* System.out.println("CURSUM"+cursum);
	    System.out.println("normalsum"+normalsum);
	    System.out.println("prevsum"+prevsum);
	    System.out.println("maxsum"+maxsum);
	     System.out.println("ele"+A[i-1]);*/
	    maxsum=Math.max(maxsum,cursum);
	    prevsum=cursum;
	}
    return maxsum;
    }	
}
