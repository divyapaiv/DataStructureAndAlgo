class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<=r;i++){
            q.offer(arr[i]);
            //System.out.println(q);
            if(q.size()>k+1){
                while(q.size()>k+1){
                    q.poll();
                 }
            }
        }
        
           while(q.size()>k && q.size()!=k){
                    q.poll();
                 }
        return(q.poll());
    } 
}
