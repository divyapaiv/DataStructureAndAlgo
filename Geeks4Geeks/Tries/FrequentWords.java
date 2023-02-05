//{ Driver Code Starts
//Initial Template for Java
//https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Trie/problem/most-frequent-word-in-an-array-of-strings3528
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java
class TrieNode{
    TrieNode []children;
    Boolean isEnd;
    int frequency;
    int pos;
    public TrieNode(){
        isEnd=false;
        frequency=0;
        pos=-1;
        children= new TrieNode [26];
        for(int i=0;i<26;i++){
            children[i]=null; 
        }
    }
}

class Solution
{
    
    public int getFrequency(String s, TrieNode root,int firstOccurent,int curmax){
        TrieNode cur=root; 
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(cur.children[idx]==null){
                cur.children[idx]=new TrieNode();
            }
            cur=cur.children[idx];
        }
        cur.frequency+=1;
        cur.isEnd=true;
        return cur.frequency;
    }
    
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {  HashMap<String,Integer> firstoccurence=new HashMap<>();
       int maxfreq=Integer.MIN_VALUE;
       TrieNode root=new TrieNode();
       int curfreq=0;
       int maxfreq_idx=-1;
       
       for(int i=0;i<arr.length;i++){
           curfreq=getFrequency(arr[i],root,i,maxfreq);
           if(!firstoccurence.containsKey(arr[i])){
               firstoccurence.put(arr[i],i);
           }
           if(curfreq>maxfreq){
               maxfreq=curfreq;
               
                   maxfreq_idx=firstoccurence.get(arr[i]);
                    
           }
           else if(curfreq==maxfreq){
               if(maxfreq_idx<firstoccurence.get(arr[i])){
                   maxfreq_idx=firstoccurence.get(arr[i]);
               }
           }
       }
       return arr[maxfreq_idx];
    }

}


//{ Driver Code Starts.
// } Driver Code Ends
