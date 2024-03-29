//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Meeting{
    int start;
    int end; 
    public Meeting(int start,int end){
        this.start=start;
        this.end=end; 
    }
}
class MeetingComparator implements Comparator<Meeting>{
    public int compare(Meeting m1, Meeting m2){
        if(m1.end>m2.end) return 1; 
        if(m1.end==m2.end) return 0; 
        return -1;
        
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Meeting> meetings  = new ArrayList<Meeting>();
        int prev_end_dt = 0; 
        int count = 0;
        if(n<=0) return 0; 
        for(int i=0;i<n;i++){
            meetings.add(new Meeting(start[i],end[i]));
        }
        Collections.sort(meetings, new MeetingComparator());
        prev_end_dt=meetings.get(0).end;
        count=1;
        for(int i=1;i<n;i++){
           if(prev_end_dt<meetings.get(i).start){
               prev_end_dt=meetings.get(i).end;
               count++;
           }
        }
        return count;
        
    }
}
