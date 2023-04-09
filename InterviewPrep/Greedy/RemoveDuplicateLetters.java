//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeDuplicateLetters(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static String removeDuplicateLetters(String S)
    {
        //HashMap<Character,PriorityQueue<Integer>> charactermap=new HashMap<>();
        int []charcnt=new int[26];
        ArrayDeque<Character> res=new ArrayDeque<>();
        
        boolean[] exists=new boolean[26];
        for(int i=0;i<S.length();i++){
            int curchar=S.charAt(i)-'a';
            charcnt[curchar]++;
        }
        //System.out.println(charactermap);
       // res[0]=S.charAt(i);
       // charcnt[res[0]-'a']--;
        //int k=1;
       for(int i=0;i<S.length();i++){
           char ch=S.charAt(i);
            while(res.size()>0 && res.peek()>ch && charcnt[res.peek()-'a']>0 && exists[ch-'a']==false){
                exists[res.peek()-'a']=false;
                res.pop();
            }
            if(exists[ch-'a']==false){
            res.push(ch);
            exists[ch-'a']=true;
            }
            charcnt[ch-'a']--;
            
        }
        String str="";
        while(res.size()>0){
            str=res.pop()+str;
        }
        return str;
    }
} 
