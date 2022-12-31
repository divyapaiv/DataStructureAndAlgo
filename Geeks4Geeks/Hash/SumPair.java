//{ Driver Code Starts You are given an array of distinct integers and a sum. Check if there's a pair with the given sum in the array.
// Initial Template for Java
//https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/hashing-for-pair-1
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String[] args) {

        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking count of testcases
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            // taking size of array
            int N = sc.nextInt();
            int arr[] = new int[N]; // array declaration

            for (int i = 0; i < N; i++) arr[i] = sc.nextInt(); // Input the
                                                               // array

            int sum = 0;

            // taking sum
            sum = sc.nextInt();

            // Creating an object of class Geeks
            Geeks obj = new Geeks();

            // Calling sumExists method of class Geeks
            // and printing the result
            System.out.println(obj.sumExists(arr, N, sum));
        }
    }
}

// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Geeks {
    // Complete this function
    // Function to check if there is a pair with the given sum in the array.
    public static int sumExists(int arr[], int N, int sum) {
        // Your code here, Geeks
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<N;i++){
            if(hs.contains(sum-arr[i]))
            return 1;
            hs.add(arr[i]);
        }
        return 0;
    }
}
