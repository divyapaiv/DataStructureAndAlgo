
// { Driver Code Starts
import java.io.*;
import java.util.*;
/*https://practice.geeksforgeeks.org/contest/interview-series-66/problems/# 

Input: chairs = [2,2,6,6], passengers = [1,3,2,6]
Output: 4
Explanation: Note that there are two chairs at position 2 and two chairs at position 6.
The students are moved as follows:
- The first passenger is moved from position 1 to position 2 using 1 move.
- The second passenger is moved from position 3 to position 6 using 3 moves.
- The third passenger is not moved.
- The fourth passenger is not moved.
In total, 1 + 3 + 0 + 0 = 4 moves were used.

*/

class IntArray {
  public static int[] input(BufferedReader br, int n) throws IOException {
    String[] s = br.readLine().trim().split(" ");
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(s[i]);

    return a;
  }

  public static void print(int[] a) {
    for (int e : a)
      System.out.print(e + " ");
    System.out.println();
  }

  public static void print(ArrayList<Integer> a) {
    for (int e : a)
      System.out.print(e + " ");
    System.out.println();
  }
}

class BusCondutor {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t;
    t = Integer.parseInt(br.readLine());
    while (t-- > 0) {

      int n;
      n = Integer.parseInt(br.readLine());

      int[] chairs = IntArray.input(br, n);

      int[] passengers = IntArray.input(br, n);

      Solution obj = new Solution();
      int res = obj.findMoves(n, chairs, passengers);

      System.out.println(res);

    }
  }
}
// } Driver Code Ends

class Solution {
  public static int findMoves(int n, int[] chairs, int[] passengers) {
    // code here
    int minmoves = 0;
    Arrays.sort(chairs);
    Arrays.sort(passengers);
    for (int i = 0; i < n; i++) {
      // System.out.pri
      minmoves = minmoves + Math.abs(passengers[i] - chairs[i]);
    }
    return minmoves;

  }
}
