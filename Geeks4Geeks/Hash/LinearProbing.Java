//{ Driver Code Starts
/*Linear probing is a collision handling technique in hashing. Linear probing says that whenever a collision occurs, search for the immediate next position.

Given an array of integers and a hash table size. Fill the array elements into a hash table using Linear Probing to handle collisions. Duplicate elements must be mapped to the same position in the hash table while colliding elements must be mapped to the [(value+1)%hashSise] position.
*/
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
            int array_size = sc.nextInt();
            
            int arr[] = new int[array_size];
            for(int i = 0; i < array_size; i++)
             arr[i] = sc.nextInt();
             
            // int hash_table[] = new int[hash_size];
            // for(int i = 0; i < hash_size; i++)
            //     hash_table[i] = -1;
            Solution obj = new Solution();
            int hash_table[] = obj.linearProbing(hash_size, arr, array_size);
            
            for(int i = 0; i <hash_size; i++)
                System.out.print(hash_table[i] + " ");
             
            System.out.println();
             
        }
    }
    
}
// } Driver Code Ends


class Solution{
    //Function to fill the array elements into a hash table 
    //using Linear Probing to handle collisions.
    int[] linearProbing(int hash_size, int arr[], int sizeOfArray)
    {
        //Your code here
        int [] cache= new int[hash_size];
         for(int i=0;i<hash_size;i++){
            cache[i]=-1;
        }
       // HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<sizeOfArray;i++){
            if(!findEle(cache,arr[i],hash_size))
                cache=addElement(cache,arr[i],hash_size,sizeOfArray);
        }
        return(cache);
        
    }
    Boolean findEle(int res[],int ele,int hash_size){
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
            i=(i+1)%hash_size;
            
        }
        while(i!=j);
      return false;
    }
    int [] addElement(int res[],int ele,int hash_size,int sizeOfArray){
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
            if(res[i]==-1){
                res[i]=ele; 
                break; 
            }
            i=(i+1)%hash_size;
            
        }
        while(i!=j || i>sizeOfArray);
      
            
        
        return res;
    }
}
