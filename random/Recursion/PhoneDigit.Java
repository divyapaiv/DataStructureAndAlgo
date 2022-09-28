//{ Driver Code Starts
//Initial Template for Java

/*
Given a keypad as shown in the diagram, and an N digit number which is represented by array a[ ], 
the task is to list all words which are possible by pressing these numbers.
*/
import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends

//User function Template for Java
class Solution
{
    static String[] digits_letters =new String[10];
    static ArrayList <String> result;
    static void feedletters(){
        digits_letters[0]="";
        digits_letters[1]="";
        digits_letters[2]="abc";
        digits_letters[3]="def";
        digits_letters[4]="ghi";
        digits_letters[5]="jkl";
        digits_letters[6]="mno";
        digits_letters[7]="pqrs";
        digits_letters[8]="tuv";
        digits_letters[9]="wxyz";
        
    }
    static void findpermutations(int a[], int N,int next,String res)
        {
            String cur="";
            if(next>N-1)
            {
                //System.out.print(res+" ");
                result.add(res);
                return;
            }
                
                for(int j=0;j<digits_letters[a[next]].length();j++){
                    cur=res+digits_letters[a[next]].charAt(j); 
                    findpermutations(a,N,next+1,cur);
                    //System.out.print(cur+" ");
                    cur="";
            }
        }
    
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {   
        result=new ArrayList();
        feedletters();
        findpermutations(a,N,0,"");
        return result;
        // your code here  
    }
}


