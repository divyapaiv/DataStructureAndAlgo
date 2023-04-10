//https://www.geeksforgeeks.org/number-of-subarrays-having-sum-in-a-given-range/
//https://practice.geeksforgeeks.org/batch/test-series-bundle/track/GTS-ARRAY/problem/count-the-number-of-subarrays
//User function Template for Java
class Solution 
{  
    long getSubArray(int N,int A[],long X){
        int beg=0;
        int end=0;
        long sum=0,cnt=0;
        
        while(end<N){
            sum+=A[end];
            while(sum>X && beg<=end){
                sum-=A[beg++];
            }
            cnt+=(end-beg)+1;
            end++;
        }
        return cnt;
    }
    long countSubarray(int N,int A[],long L,long R) {
        /*Find sub array within R*/
        long RCnt=getSubArray(N,A,R);
        /*Find sub array within L*/
        long LCnt=getSubArray(N,A,L-1);
       // System.out.println(RCnt+" "+LCnt);
       //Return cnt of subarray R(MAX) -  cnt of subarray L(MAX)
        return (RCnt-LCnt);
    }
} 
