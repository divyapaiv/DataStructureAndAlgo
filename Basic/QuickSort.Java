/* 
arr =[ 10,9,2,1,7,9,11,18,5]
j=-1;
pivot = 5 
if(a[i]<5) j++; ~ 2 == (1,2)
arr =[ 2,1,5,9,7,9,11,18,10] == pivot is 2
[2,1] =[1,2]
[9,7,9,11,18,10] =[9,7,9,10,18,11] pivot is 5
=[9,7,9]= [7,9,9]
[18,11] = [11,18]
*/


//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        while(low<high){
            int p=partition(arr,low,high);
           quickSort(arr,low,p-1);
           quickSort(arr,p+1,high);
           break;
        }
    }
    static int partition(int a[], int low, int high)
    {
        int pivot =a[high];
        int j=low-1;
        for(int i=low;i<high;i++){
            if(a[i]<pivot){
                j++;
                int t=a[i]; 
                a[i]=a[j];
                a[j] = t; 
                
                
            }
        }
         int t=a[j+1]; 
         a[j+1]=a[high];
         a[high] = t; 
         return(j+1);
    } 
}
