//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[] A = new int[N];
            for(int i = 0; i < N; i++){
                A[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.minDecreasingSub(N, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int minDecreasingSub(int N, int[] A)
    {
        if(N==1) return 1;
        int minabsidx=0;
        //int curabsdis=Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> groups= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<N;i++){
            int curabsdis=Integer.MAX_VALUE;
             minabsidx= getminabsidx(groups,groups.size(),A[i]);
            /*for(int j=groups.size()-1;j>=0;j--){
                int cursize=groups.get(j).size();
                //if(cursize>0 && groups.get(j).get(cursize-1)<A[i]) break;
               if(cursize>0 && groups.get(j).get(cursize-1)>A[i]){
                    if(curabsdis>Math.abs( groups.get(j).get(cursize-1)-A[i])){
                        minabsidx=j;
                        curabsdis=Math.abs( groups.get(j).get(cursize-1)-A[i]);
                    }
                }*/
               
            
            if(minabsidx==-1)
            {
                groups.add(new ArrayList<>());
                groups.get(groups.size()-1).add(A[i]);
            }
            else{
               groups.get(minabsidx).add(A[i]); 
            }
        }
             return groups.size();
        }
        
        public int getminabsidx(ArrayList<ArrayList<Integer>> groups,int n,int ele){
            int minidx=-1;
            int low=0;
            int high=n-1;
            while(low<=high){
                int mid=(low+high)/2;
                int cursize=groups.get(mid).size()-1;
                if(groups.get(mid).get(cursize)>ele){
                    high=mid-1;
                     minidx=mid;
            
                }
                else{
                    low=mid+1;
                }
            }
            //System.out.println(groups);
             //System.out.println(minidx);
               
            return minidx;
        }   
}
