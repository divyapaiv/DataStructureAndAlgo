//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.ReFormatString(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static String ReFormatString(String res, int K){
        StringBuilder result=new StringBuilder();
        int k=0;
        if(res.length()==0) return res; 
       
        for(int i=res.length()-1;i>=0;i--){
            if(res.charAt(i)!='-'){
                int ascii=(int)res.charAt(i);
                char ch;
                 if(ascii>=97 && ascii<=122){
                       int diff=res.charAt(i)-'a';
                       ch=(char)('A'+diff);
                        
                    }
                    else{
                        ch=res.charAt(i);
                    }
                if(k<K){
            
                     result.insert(0,ch);
                    k++;
                 }
                else{
                k=1;
                result.insert(0,"-");
                result.insert(0,ch);
                 
                }
            }
        }
        return result.toString();
    }
}
