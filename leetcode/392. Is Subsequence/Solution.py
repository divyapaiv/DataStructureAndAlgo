class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        dp= list([[0 for i in range(len(s)+1)] for j in range(len(t)+1)])
        for i in range(1,len(t)+1):
             for j in range(1,len(s)+1):
                   # print(s[j-1] +"\t " + t[i-1])
                    if s[j-1] == t[i-1] :
                        dp[i][j]= dp[i-1][j-1]+1
                    else :
                        dp[i][j] =dp[i-1][j]
        '''for item in dp:
            print(item)
        print("END")'''
        if dp[len(t)][len(s)] == len(s):
            return True
        else: 
            return False
