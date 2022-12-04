class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        curmax=0
        for i in range(0,len(number)):
            if number[i]==digit :
                t= number[0:i]+number[i+1:]
               # print(t)
                curmax= max(curmax,int(t))
        return str(curmax)
        
