/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int [][] dp = new int[t.length()+1][s.length()+1];

        for(int i = 0 ;i<=t.length();i++){
                      dp[i][0] =0;
        }
         for(int i = 0 ;i<=s.length();i++){
                      dp[0][i] =0;
        }
        
        
        
        
        
        for(int i = 1 ;i<=t.length();i++){
            for(int j = 1 ;j<=s.length();j++){
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    
                }
                else{
                    dp[i][j] =dp[i-1][j];
                }
                
            }
        }
        
         /* for(int i = 0 ;i<=t.length();i++){
             for(int j = 0 ;j<=s.length();j++){
                System.out.print(dp[i][j]+"\t");
        }
              System.out.println("\n");
        }*/
       // System.out.println(dp[t.length()-1][s.length()-1]);
        if(dp[t.length()][s.length()]==s.length())
            return true;
        else 
            return false;
        
    }
}
