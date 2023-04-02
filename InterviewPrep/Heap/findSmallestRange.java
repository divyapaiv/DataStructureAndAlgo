class Ele{
    int x;
    int y; 
    int val;
    public Ele(int x,int y, int val){
        this.x=x;
        this.y=y;
        this.val=val;
    }
    
}
class Solution
{
	static int[] findSmallestRange(int[][] A,int n,int k)
	{
	    int minrange=Integer.MAX_VALUE;
	    int curmax=Integer.MIN_VALUE;
	    int [] res= new int[2];
	    PriorityQueue<Ele> minheap=
	    new PriorityQueue<Ele>((a,b)->a.val-b.val);
	    for(int i=0;i<k;i++){
	        minheap.offer(new Ele(i,0,A[i][0]));
	        if(curmax<A[i][0]){
	            curmax=A[i][0];
	        }
	    }
	    while(minheap.size()>0){
	        Ele e= minheap.poll();
	        if(curmax-e.val<minrange){
	            minrange=Math.min(curmax-e.val,minrange);
	            res[0]=e.val;
	            res[1]=curmax;
	        }
	        if(e.y+1>=n) break;
	        else{
	            minheap.offer(new Ele(e.x,e.y+1,A[e.x][e.y+1]));
	            if(curmax<A[e.x][e.y+1]){
	            curmax=A[e.x][e.y+1];
	             }
	        }
	        
	        
	    }
	    return res;
	}
}
