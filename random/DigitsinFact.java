//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */
/* Factoria(N)= N*N-1*N-2....1; 
Log(Factorial(N))= LOG(N*N-1*N-2....1)
LOG(A*B)=LOG(A)+LOG(B);
Digits in a number = LOG<Base10>(NUM)+1;
*/

import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // taking total testcases
    int T = sc.nextInt();

    while (T-- > 0) {
      Solution obj = new Solution();
      int N;

      // taking N
      N = sc.nextInt();

      // calling method digitsInFactorial()
      System.out.println(obj.digitsInFactorial(N));

    }

  }
}

// } Driver Code Ends

// User function Template for Java

class Solution {

  public int digitsInFactorial(int N) {
    // code here
    double digits = 0;
    if (N < 0)
      return 0;
    if (N <= 1)
      return 1;
    for (int i = 2; i <= N; i++)
      digits += Math.log10(i);

    return (int) (Math.floor(digits)) + 1;
  }
}
