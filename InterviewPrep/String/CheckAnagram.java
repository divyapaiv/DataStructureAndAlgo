//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();
            Solution ob = new Solution();
            if(ob.checkAnagram(S1, S2)) 
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    public static boolean checkAnagram(String S1, String S2)
    {
        int [] charcntS1= new int[26];
        int [] charcntS2= new int[26];
        int n=S1.length();
        int m=S2.length();
        if(n>m) return false;
        for(int i=0;i<n;i++)
        {
            int idx=S1.charAt(i)-'a';
            charcntS1[idx]++;
        }
        int start=0,end=0;
        
            while(end<S1.length()){
                charcntS2[S2.charAt(end)-'a']++;
                end++;
                }
        
        boolean res=detectAnagram(charcntS1,charcntS2);
        if(!res){
            while(end<m){  
            if(start<=end){
                res=detectAnagram(charcntS1,charcntS2);
                if(res) return true;
                int idx=S2.charAt(start)-'a';
                charcntS2[idx]--; 
                start++;
            }
            int idx=S2.charAt(end)-'a';
            charcntS2[idx]++;
            end++;
            }
        }
        else {
            return true;
        }
        
          res=detectAnagram(charcntS1,charcntS2);
         if(res) return true;
        return false;
    }
    public static boolean detectAnagram(int [] charcntS1,int [] charcntS2){
        for(int i=0;i<26;i++)
        {
            if(charcntS1[i]!=charcntS2[i]) return false;
        }
  
        return true;
    }
} 
