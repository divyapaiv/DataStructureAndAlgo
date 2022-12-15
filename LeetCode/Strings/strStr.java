/*
28. Find the Index of the First Occurrence in a String
Medium
1.1K
83
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        int [][]cache= new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            cache[i][0]=0;
        }
        for(int i=0;i<=n;i++){
            cache[0][i]=0;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++){
                if(haystack.charAt(i-1)==needle.charAt(j-1)){
                     cache[i][j]=cache[i-1][j-1]+1;
                     //System.out.println(cache[i][j]+ " "+n);
                     if(cache[i][j]==n){
                         return(i-n);
                     }
                }

            }
        }
        return(-1);
    }
}
