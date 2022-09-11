
//{ Driver Code Starts
//Initial Template for Java
/*package whatever //do not write package name here */
//GeeksforGeeks convert-celsius-to-fahrenheit
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();// input number of testcases
    while (T-- > 0) {
      Solution obj = new Solution();

      int C;
      C = sc.nextInt();// input temperature in celscius

      System.out.println((int) (obj.cToF(C)));// print the output
    }

  }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
  public double cToF(int C) {
    // Your code here
    double constval = (double) ((double) 9 / (double) 5);
    // System.out.println(constval);
    double faren = ((constval * (double) C) + (double) 32);
    return (faren);
  }
}
