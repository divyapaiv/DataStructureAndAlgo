//{ Driver Code Starts
//Initial Template for Java
//shortest-unique-prefix-for-every-word
/*
Given an array of words, find all shortest unique prefixes to represent each word in the given array. Assume that no word is prefix of another.*/
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class TrieNodes{
    TrieNodes []child;
    Boolean isEnd;
    int []count;
    public TrieNodes(){
        isEnd=false;
        child=new TrieNodes[26];
        count=new int[26];
        for(int i=0;i<26;i++){
            child[i]=null;
            count[i]=0;
        }
    }
}
class Solution {

    public static void insert(String key,TrieNodes root){
        TrieNodes cur=root;
       
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            
            if(cur.child[idx]==null){
                cur.child[idx]=new TrieNodes();
                cur.count[idx]=1;
            }
            else
            {
                cur.count[idx]+=1;
            }
            
            cur = cur.child[idx];
            
        }
         cur.isEnd=true;
    }
    
     public static String fetchPrefix(String key,TrieNodes root){
        TrieNodes cur=root;
        String prefix="";
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            
            if(isEmpty(cur,idx)){
                return prefix;
            }
            prefix+=key.charAt(i);
           
            cur=cur.child[idx];
            
        }
        return key;
    }
    public static boolean isEmpty(TrieNodes root,int curpos)
    {
        for(int i=0;i<26;i++){
         if(root.child[i]!=null && i!=curpos )  {
             return false;
         } 
        }
        if(root.child[curpos]!=null && root.count[curpos]==1)
            return true;
        else return false;
    }
    static String[] findPrefixes(String[] arr, int N) {
        TrieNodes root=new TrieNodes();
        String [] res=new String[N];
        for(int i=0;i<N;i++){
            insert(arr[i],root);
        }
         for(int i=0;i<N;i++){
            res[i]=fetchPrefix(arr[i],root);
        }
        return res;
        
    }
};
