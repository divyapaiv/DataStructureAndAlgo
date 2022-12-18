/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int s_len=word1.length();
        int t_len=word2.length();
        int [][]cache = new int[s_len+1][t_len+1];
        if(s_len==0 || word1=="") return t_len; 
         if(t_len==0 || word2=="") return s_len; 
        for(int i=0;i<s_len;i++){
            cache[i][0]=i;
        }
        for(int i=0;i<=t_len;i++){
            cache[0][i]=i;
        }
        for(int i=1;i<=s_len;i++){
            for(int j=1;j<=t_len;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    cache[i][j]=cache[i-1][j-1];
                }
                else
                {
                    cache[i][j]= Math.min(1+cache[i-1][j-1],
                        Math.min(1+cache[i-1][j],1+cache[i][j-1])
                    );
                }
            }
        }
        System.out.println(Arrays.deepToString(cache));

        return(cache[s_len][t_len]);
    }
}
