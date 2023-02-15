//{ Driver Code Starts
//Initial Template for JAVA
/*
Given a set of N intervals denoted by 2D array A of size N x 2. Find the length of maximal set of mutually disjoint intervals.
Two intervals [x, y] & [p, q] are said to be disjoint if they do not have any point in common.
*/
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int N = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> A = new ArrayList<>();
            
            for(int i=0; i<N; i++)
            {
                ArrayList<Integer> interval = new ArrayList<>();
                String S[] = read.readLine().split(" ");
                interval.add(Integer.parseInt(S[0]));
                interval.add(Integer.parseInt(S[1]));
                A.add(interval);
            }

            Solution ob = new Solution();
            System.out.println(ob.disjointIntervals(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class compareArray implements Comparator<ArrayList<Integer>>{
    public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
        if(a.get(1)<b.get(1)) return -1;
        if(a.get(1)==b.get(1)) return 0;
        return 1;
    }
}
class Solution {
    static int disjointIntervals(ArrayList<ArrayList<Integer>> A, int N) {
        // code here
           //for( ArrayList<Integer> i:A){
          //  System.out.println(i.toString());
       /*
Sort the intervals, with respect to their end points.
Now, traverse through all the intervals, if we get two overlapping intervals, then greedily choose the interval with lower end point since, choosing it will ensure that intervals further can be accommodated without any overlap.
Apply the same procedure for all the intervals and print all the intervals which satisfy the above criteria.
           }*/
        int count=0;
        int curminstart=Integer.MAX_VALUE;
        int curminend=Integer.MAX_VALUE;
        boolean isFinalIncluded=false;
        Collections.sort(A,new compareArray());
        
        curminstart=A.get(0).get(0);
        curminend=A.get(0).get(1);
        count=1;
       // System.out.println("Array");
        for( int i=1;i<A.size();i++){
        //System.out.println(A.get(i).toString());
        if(curminend<A.get(i).get(0)){
            count++;
            curminend=A.get(i).get(1);
        }
        else{
            curminend= Math.min(curminend,A.get(i).get(1));
        }
     
        
        }
        return count;
    }
};
