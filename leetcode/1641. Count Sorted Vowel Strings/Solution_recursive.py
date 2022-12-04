class Solution:
    vowels = ['a','e','i','o','u']
    result = 0
    def countVowelsstrs(self, idx:int, n: int,res: str) -> int:
        result=0
        if n == 1:
            return 5
        if(idx==len(self.vowels)): 
            return 0
        if(len(res)==n):
            #print(res)
            return 1
        result= result + self.countVowelsstrs(idx,n,(res + self.vowels[idx]))
        for i in range(idx,len(self.vowels)): 
            result = result + self.countVowelsstrs(i+1,n,(res+self.vowels[i]))
        return result
    
    def countVowelStrings(self, n: int) -> int:
        res=""
        if n==0 : return 0
        else :
            return(self.countVowelsstrs(0,n,res))
