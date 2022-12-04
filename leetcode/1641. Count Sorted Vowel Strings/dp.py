'''
 n = 1 ~ [ 1, 1, 1, 1, 1 ] 
 n = 2 ~ [ 5, 4, 3, 2, 1 ] = sum ( [ 5, 4, 3, 2, 1 ] ) = 15 
 n = 3 ~ [ 15 ,10 , 6, 3, 1 ]
 
 
 
 dp[j]=dp[j]+dp[j+1]
 


'''

class Solution:
    vowels = ['a','e','i','o','u']
    result = 0
    
    def countVowelStrings(self, n: int) -> int:
        dp = list(1 for i in range(len(self.vowels)))
        if n==0 : return 0
        else :
            for i in range(2,n+1):
                for j in range(3,-1,-1):
                    dp[j]=dp[j]+dp[j+1]
            x=0
            for i in dp:
                x = x+ i
            return(x)
