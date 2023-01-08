//{ Driver Code Starts
/*

Given two sorted arrays A and B of size M and N respectively. 
Each array may have some elements in common with the other array.
Find the maximum sum of a path from the beginning of any array to the end of any of the two arrays. 
We can switch from one array to another array only at the common elements.Both the arrays are sorted.
Note: Only one repeated value is considered in the valid path sum.
Input:
M = 5, N = 4
A[] = {2,3,7,10,12}
B[] = {1,5,7,8}
Output: 35
Explanation: The path will be 1+5+7+10+12
= 35.
O(M+N)
*/
import java.util.*;

class ArrPathSum1
{
	// Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		Solution g = new Solution();
		System.out.println(g.maxPathSum(ar1,ar2));
		T--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method
    * ar1 : 1st array
    * ar2 : 2nd array
    */
    int maxPathSum(int a[], int b[])
    {
        int maxsum1=0;
        int maxsum2=0;
        int maxsum=0;
        int n=a.length;
        int m=b.length;
        int j=0,i=0; 
        while(i<n && j<m){
            if(a[i]<b[j]){
                maxsum1=maxsum1+a[i];
                i++;
                
            }
            else if(b[j]<a[i])
            {
                maxsum2=maxsum2+b[j];
                j++;
            }
            else if(b[j]==a[i]){
                if(maxsum1>maxsum2){
                    maxsum+=maxsum1+b[j];
                }
                else if(maxsum1<maxsum2)
                {
                    maxsum+=maxsum2+b[j];
          
                }
                else 
                {
                     maxsum+=maxsum2+b[j];
            
                }
                maxsum1=0;
                maxsum2=0;
                i++;j++;
            }
       // System.out.println(maxsum);
        }
        while(i<n ){
            maxsum1+=a[i];i++;
        }
        while(j<m ){
            maxsum2+=b[j];j++;
        }
    
         maxsum+=Math.max(maxsum1,maxsum2);
        return maxsum;
    }
}
