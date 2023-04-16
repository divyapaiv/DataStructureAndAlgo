//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.MinParentheses(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int MinParentheses(String S) {
        int cnto=0;
        int cntc=0;
        int reqcnt=0;
        for(int i=0;i<S.length();i++){
            char ch1=S.charAt(i);
            if(ch1=='('){
                cnto++;
            }
            else {
              cntc++;  
            }
            if(cntc>cnto){
              reqcnt+=Math.abs(cnto-cntc); 
              cntc=0;
              cnto=0;
            }
        }
         reqcnt+=Math.abs(cnto-cntc);
        return reqcnt;
        
    }
};
