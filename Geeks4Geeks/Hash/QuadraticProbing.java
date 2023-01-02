//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- >0)
        {
            int hash_size = sc.nextInt();
            int N= sc.nextInt();
            
            int arr[] = new int[N];
            
            for(int i = 0; i < N ; i++)
             arr[i] = sc.nextInt();
             
            int hash_table[] = new int[hash_size];
            Solution obj = new Solution();
            obj.quadraticProbing(hash_table, hash_size, arr, N);
            
            for(int i = 0; i <hash_size; i++)
             System.out.print(hash_table[i] + " ");
             
             System.out.println();
             
        }
    }
    
}

// } Driver Code Ends


class Solution{
    //Function to fill the array elements into a hash table 
    //using Quadratic Probing to handle collisions.
    static void quadraticProbing(int[] cache, int hash_size, int arr[], int N)
    {
        
        
         for(int i=0;i<hash_size;i++){
            cache[i]=-1;
        }
       // HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<N;i++){
           cache=addElement(cache,arr[i],hash_size,N);
        }
       
        
    }
     static Boolean findEle(int res[],int ele,int hash_size){
         int slot=ele%(hash_size); 
         int i=slot,j=slot; 
       /*  if(ele==2695 ){
             System.out.println(slot+"  "+res[slot]);
          for(int k=0;k<hash_size;k++){
            System.out.print("["+k+" "+res[k]+"], ");
        }
        
         }*/
         
        do
        {
            if(res[i]==ele){
                return true;
            }
            i=((i+1)*(i+1))%hash_size;
            
        }
        while(i!=j && res[i]!=-1);
      return false;
    }
     static int [] addElement(int res[],int ele,int hash_size,int sizeOfArray){
        int slot=ele%(hash_size); 
        int i=slot,j=slot; 
       /*  if(ele==2695 ){
             System.out.println(slot+"  "+res[slot]);
          for(int k=0;k<hash_size;k++){
            System.out.print("["+k+" "+res[k]+"], ");
        }
        
         }*/
       if(res[i]==-1 || res[i]==ele){ 
           res[i]=ele;
       }
     else{
         
      for (j = 1; j < hash_size; j++) {
          
             int t = (i + j * j) % hash_size;
             if(res[t]==-1 || res[t]==ele)
             {
                 res[t]=ele;
                 break;
             }
           
            
        }
    
      
     }
        
        return res;
    }
}
