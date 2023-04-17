//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        int [] lcs= new int[size+1];
        int start=0,end=0;
        for(int i=0;i<size;i++){
            
            if(end==0 || lcs[end-1]<a[i]){
               
                lcs[end]=a[i];
                end++;
            } 
            else{
              
            int pos=getElePos(lcs,size,a[i],start,end);
               //System.out.println(" "+a[i]+" "+" "+pos+Arrays.toString(lcs));
            
            lcs[pos]=a[i];
            }
        }
    
        return end;
    }
    static int getElePos(int a[],int size,int key, int start, int end){
        int l=start;
        int h=end-1,result=0;
        while(l<=h){
            int mid=(l+h)/2;
            if(a[mid]==key){
                return mid;
            }
            else if(a[mid]>key){
                result=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return result;
    }
} 
