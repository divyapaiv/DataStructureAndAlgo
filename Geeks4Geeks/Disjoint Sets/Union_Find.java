//{ Driver Code Starts
//Initial Template for Java

import java.io.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        
        //using BufferedReader to take input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //taking total testcases
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            
            //taking total number of elements
            int n = Integer.parseInt(br.readLine());
            
            int par[] = new int[n+1];
            int rank[] = new int[n+1];
            
            //initializing the parent and
            //the rank array
            for(int i = 1; i<=n; ++i){
                par[i] = i;
                rank[i] = 1;
            }
            int a = 0, b = 0;
            char c = '0';
            
            //taking number of queries
            int query = Integer.parseInt(br.readLine());
            
            Boolean output = false;
            while(query-- >0){
                String str[] = br.readLine().trim().split(" ");
                c = str[0].charAt(0);
                a = Integer.parseInt(str[1]);
                b = Integer.parseInt(str[2]);

                //if query type is 'U'
                //then calling union_ method
                if(c == 'U'){
                    new Solution().union_(a, b, par, rank);
                }
                else{//else calling isConnected() method
                    output = new Solution().isConnected(a, b, par, rank);
                    if(output == true)
                        System.out.println("1");
                    else
                        System.out.println("0");
                }
            }



        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge two nodes a and b.
    public void union_(int a, int b, int par[], int rank[])
    {
        
 int x,y;
// System.out.println("A :"+a+" B:"+b);
      if(par[a]==par[b]) return; 
      x=find(par[a],par);
      y=find(par[b],par);
          if(rank[a]<rank[b]){
           par[x]=y;
           
       }
       else if(rank[a]>rank[b]){
           par[y]=x;
       }
       else{
           par[y]=x;
           rank[x]++;
       }    
       
    }
    int find(int x,int par[]){
        //System.out.println("X:" + x);
       // System.out.println(java.util.Arrays.toString(par));
       // System.out.println(java.util.Arrays.toString(rank));
        if(par[x]==x) return x; 
        else {
           par[x]=find(par[x],par);
         
            return par[x];
        }
        
    }
        
    

    //Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        // add your code here
       // if(a==13){
          //  System.out.println(java.util.Arrays.toString(par));
           // System.out.println(java.util.Arrays.toString(rank));
       // }
        if(par[a]==par[b]) return true; 
        int x=find(par[a],par);
        int y=find(par[b],par);
     if(a==13){
      //System.out.println(java.util.Arrays.toString(par));
        //System.out.println(java.util.Arrays.toString(rank));
      //  System.out.println("X:" + x);
       //  System.out.println("Y:" + y);
       //  System.out.println(java.util.Arrays.toString(par));
        //System.out.println(java.util.Arrays.toString(rank));
       }
        if(x==y) return true; 
        else return false;
    }

}
