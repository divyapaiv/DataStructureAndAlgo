//{ Driver Code Starts
//Initial Template for Java
//https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Trie/problem/renaming-cities28581833
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    String arr[]=new String[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLine();
		        
		    }
		    new Solution().check(arr,n);
		    
		    
		}
	}


	
}

class Node
{
    public boolean isEndOfWord;
    public TreeMap<Character,Node>mp;
    public Node()
    {
        isEndOfWord=false;
        mp=new TreeMap<>();
    }
}

// } Driver Code Ends


//User function Template for Java
class TrieNodes{
    TrieNodes []child;
    Boolean isEnd;
    int count;
    public TrieNodes(){
        isEnd=false;
        count=0;
        child=new TrieNodes[26];
        for(int i=0;i<26;i++){
            child[i]=null;
        }
    }
}
class Solution
{
    public static String findStationId(String key,TrieNodes root){
        TrieNodes cur=root;
        String curfix="",prefix="";
        Boolean inserted=false;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            curfix+=key.charAt(i);
            if(cur.child[idx]==null){
                
                if(inserted== false)
                    prefix=curfix;
                inserted=true;
                cur.child[idx]=new TrieNodes();
            }
            
            cur = cur.child[idx];
            
        }
        
        cur.count+=1;
        if(prefix=="" && inserted== false && cur.isEnd==true){
            curfix=curfix+" "+cur.count;
            return curfix;
        }
        else if(prefix==""){
            prefix=curfix;
        }
         cur.isEnd=true;
      
        return prefix;
    }
    public static void check(String arr[],int n)
    {
        TrieNodes root=new TrieNodes(); 
        for(String s:arr){
            String res=findStationId(s,root);
            System.out.println(res);
        }
    }
}
