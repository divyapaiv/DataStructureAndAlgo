//{ Driver Code Starts
//Initial template for JAVA
/*
Given an array of integers and a sum B, find all unique combinations in the array where the sum is equal to B. The same number may be chosen from the array any number of times to make B.

Note:
        1. All numbers will be positive integers.
        2. Elements in a combination (a1, a2, …, ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        3. The combinations themselves must be sorted in ascending order.


*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    static ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>(); 
    static void getCombination(ArrayList<Integer> A, int B,
    ArrayList<Integer> interim,int pos)
    {
        
        if(B==0){
           // System.out.println(interim);
           if(!result.contains(interim))
                result.add(new ArrayList<Integer>(interim));
           //System.out.println(result);
           return;
           
        }
        else if(B<0){
            return;
        }
      else if(pos>=A.size()){
            return;
        }
        else{
           for(int i=pos;i<A.size();i++){
               if(A.get(i)<=B){
                   if((i>0 && A.get(i)!=A.get(i-1)) || (i==0)){
                        ArrayList<Integer> temp= new ArrayList<Integer>(interim);
              
                         temp.add(A.get(i));
                        getCombination(A,B-A.get(i),temp,i);
               }
               
           }
          
        }
    }
    }
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
       
        Collections.sort(A);
        if(A.size()<=0 ) return result;
        getCombination(A,B,new ArrayList<Integer>(),0);
            return result;
    
        
        
    }
}
