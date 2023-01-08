//{ Driver Code Starts
// Initial Template for Java
/*https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
O(N)
Input:
N = 4
A[] = {1,2,3,2}
x = 1, y = 2
Output: 1
Explanation: x = 1 and y = 2. There are
two distances between x and y, which are
1 and 3 out of which the least is 1.
keep a track of last found x or y and compute min again if it's very close and different

*/

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Solution g = new Solution();
            System.out.println(g.minDist(a, n, x, y));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minDist(int a[], int n, int x, int y) {
        // code here
        int i=0,p=-1;
        int minval=Integer.MAX_VALUE;
        for(i=0;i<n;i++){
            if(a[i]==x || a[i]==y){
                if(p!=-1 && a[i]!=a[p]){
                    minval=Math.min(minval,i-p);
                }
                p=i;
            }
        }
        if(minval==Integer.MAX_VALUE ) return -1;
        else return minval;
       
    }
}
