/https://practice.geeksforgeeks.org/batch/test-series-bundle/track/gts-dynamic-programming/problem/count-ways-to-partition-a-string-such-that-both-parts-have-equal-distinct-characters/
class Solution {
    int CountWays(String S) {
       HashMap<Character,Integer> cache=new HashMap<>();
        int n=S.length(),ways=0;
       int []left=new int[S.length()];
      int []right=new int[S.length()];
       for(int i=0;i<S.length();i++){
           cache.put(S.charAt(i),1);
           left[i]=cache.size();
       }
       cache.clear();
        for(int i=n-1;i>=0;i--){
           cache.put(S.charAt(i),1);
           right[i]=cache.size();
       }
     
         for(int i=1;i<n;i++){
            if(left[i-1]==right[i])ways++;
            
         }
         return ways;
       
    }
};
