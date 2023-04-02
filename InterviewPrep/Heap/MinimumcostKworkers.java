//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] Q = new int[N];
            
            for(int i=0; i<N; i++)
                Q[i] = Integer.parseInt(S1[i]);
                
            String S2[] = read.readLine().split(" ");
            
            int[] W = new int[N];
            
            for(int i=0; i<N; i++)
                W[i] = Integer.parseInt(S2[i]);
                
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.format("%.5f", ob.minCost(Q, W, K));
            System.out.println();
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java,
class Worker{
    Integer work;
    Integer quality;
    Double ratio;
    public Worker(Integer work,Integer quality){
        this.work=work;
        this.quality=quality;
        this.ratio=(double)work/(double)quality;
    }
    
    public String toString(){
        return "W :"+work+" Q:"+quality;
    }
}
class Solution{
    public double minCost(int[] Q, int[] W, int K) {
        ArrayList<Worker> workers= new ArrayList<Worker>();
        PriorityQueue<Integer> quality = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0;i<W.length;i++){
           Worker temp = new Worker(W[i],Q[i]);
           workers.add(temp);
        }
       // Sort workers based on ratio
        Collections.sort(workers,(a,b)->{
            return a.ratio.compareTo(b.ratio);
            
        });
        double cursum=0.0;
        //Add first K-1 workers into heap
        for(int i=0;i<K;i++){
           quality.offer(workers.get(i).quality);
           cursum+=workers.get(i).quality;
       }
        // determine minvalue with current k-1 workers. 
        double curmin=(double)cursum*(double)(workers.get(K-1).work/workers.get(K-1).quality);
        //Keep on adding a new workers whenever they have less quality over current quality on maxheap.
        for(int captain=K;captain<workers.size();captain++){
            double captainratio=(workers.get(captain).work/workers.get(captain).quality);
            if(quality.size()>0 && workers.get(captain).quality<quality.peek()){
                double temp=quality.poll();
                cursum-=temp;
                cursum+=workers.get(captain).quality;
                quality.offer(workers.get(captain).quality);
            }
            curmin=Math.min(curmin,cursum*(double)captainratio);
        }
        return curmin;
    }
}
