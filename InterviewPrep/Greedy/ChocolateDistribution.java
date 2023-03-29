//User function Template for Java

class Solution
{
    public int distributeCandies(int[] A)
    {
        int []candy = new int[A.length];
        Arrays.fill(candy,1);
        int candycnt=0;
        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1]){
                candy[i]=candy[i-1]+1;
        }
        }
        // System.out.println(Arrays.toString(candy));
        for(int i=A.length-2;i>=0;i--){
            if(A[i]>A[i+1]){
                if(i-1>=0)
                    candy[i]=Math.max(candy[i+1]+1,candy[i]);
                else{
                    candy[i]=candy[i+1]+1;
                }
            }
            /*else{
                candy[i]=Math.max(candy[i+1],candy[i]);
            }*/
        }
    
  //  System.out.println(Arrays.toString(candy));
    for(int i=0;i<candy.length;i++){
            candycnt+=candy[i];
        }
        return candycnt;
}
}
