//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    //Function to insert heap.
    static PriorityQueue<Integer> leftMinHeap= new PriorityQueue<>(Collections.reverseOrder());
   static PriorityQueue<Integer> rightMaxHeap=new PriorityQueue<>();

        
       // leftMinHeap
        
    
    public static void insertHeap(int x)
    {
        if(leftMinHeap.size()>rightMaxHeap.size()){
            if(x<leftMinHeap.peek()){
                int ele=leftMinHeap.poll();
                leftMinHeap.offer(x);
                rightMaxHeap.offer(ele);
            }
            else{
                rightMaxHeap.offer(x);
            }
        }
        else{
            if(rightMaxHeap.size()>0 && rightMaxHeap.peek()<x){
                  int ele=rightMaxHeap.poll();
                leftMinHeap.offer(ele);
                rightMaxHeap.offer(x);
            }
            else{
                leftMinHeap.offer(x);
            }
        }
       
        // add your code here
    }
    

    
    //Function to return Median.
    public static double getMedian()
    {
      //System.out.println(leftMinHeap);
      //System.out.println(rightMaxHeap+" "+(leftMinHeap.size()+rightMaxHeap.size()));
       if((leftMinHeap.size()+rightMaxHeap.size())%2==0){
          // System.out.println(rightMinHeap+" "+(leftMinHeap.peek()+rightMaxHeap.peek()));
            return (leftMinHeap.peek()+rightMaxHeap.peek())/2;
       }
       else 
            return leftMinHeap.peek();
        
    }
    
}
