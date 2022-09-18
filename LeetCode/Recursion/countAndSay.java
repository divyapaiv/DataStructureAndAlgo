/*https://leetcode.com/problems/count-and-say/
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. 
Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

Algorithm: 
Base Case if(n==1) return 1
call function recursively for n-1 
when it reaches 1. It will return 1 as result.
count digits in each returned result and append it to final result and return the final result



*/
class CountAndSay {
    public String countAndSay(int n) {
        String finalresult="";
        if(n==1)
            return "1";
        else
        {
            int i=0;
            Integer counter=1;
            String result=countAndSay(n-1);

            while(i<=result.length()-1){

                if(i==result.length()-1 ){
                    
                    finalresult=finalresult+counter.toString() +result.charAt(i);
                     
                    counter=1;
                }
                else if(result.charAt(i)!=result.charAt(i+1)){
                    
                    finalresult=finalresult+counter.toString() +result.charAt(i);
                    counter=1;
                }
                else 
                {
                    counter++;
                }
                i++;
                
                    
            }
               
            return(finalresult);
            
            
        }
        
    }
}