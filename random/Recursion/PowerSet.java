//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class PowerSet
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        //testcases        
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //input string
            String st = sc.next();
            
            //calling powerSet() function
            ArrayList<String> ans = new LexSort().powerSet(st);
            
            //sorting the result of the powerSet() function
            Collections.sort(ans);
    
            //printing the result
            for(String s: ans)
                System.out.print(s + " ");
            System.out.println();    
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class LexSort
{
   //static sortedSet set = new TreeSet();  
    static ArrayList<String> arr=new ArrayList<String>();
    static SortedSet<String> arr1=new TreeSet<String>();
    static void lexpowerset(String res,int index,int size,String input){
        if(index>size){
            arr.add(res);
            return;
        }
        else
        {
            lexpowerset(res,index+1,size,input);
            lexpowerset(res+input.charAt(index),index+1,size,input);
        }
            
        
    }
    //Function to return the lexicographically sorted power-set of the string.
    static ArrayList<String> powerSet(String s)
    {   
        //char [] c= s.toCharArray(); 
       // Arrays.sort(c);
        //s=new String(c);
        //System.out.println(s);
        arr=new ArrayList<String>();
        
        lexpowerset("",0,s.length()-1,s);
        return (new ArrayList<String>(arr));
    }

}


 

//{ Driver Code Starts.

                              
// } Driver Code Ends