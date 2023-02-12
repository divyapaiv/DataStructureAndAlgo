//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

class JobCompare implements Comparator<Job>{
    public int compare(Job j1, Job j2){
        if(j2.profit > j1.profit) return 1;
        if(j2.profit == j1.profit) return 0;
        return -1;
    }
}
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int [] result = new int[2];
        int [] allotted_tasks = new int[n+1];
        int filled_cnt=0;
        Arrays.sort(arr,new JobCompare());
        for(int i=0;i<n;i++){
            if(allotted_tasks[(arr[i].deadline-1)]==0){
              allotted_tasks[(arr[i].deadline-1)]=arr[i].id;
              result[0]+=1;
              result[1]+=arr[i].profit;
              filled_cnt++;
            }
            else{
                int idx=(arr[i].deadline-1); 
                while(idx>=0){
                    if(allotted_tasks[idx]==0){
                        allotted_tasks[idx]=arr[i].id;
                        result[0]+=1;
                        result[1]+=arr[i].profit;
                        filled_cnt++;
                        break;
                    }
                    idx--;
                }
                
            }
            if(filled_cnt>=n) {
                break;
            }
            
        }
        return result;
        
        
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
