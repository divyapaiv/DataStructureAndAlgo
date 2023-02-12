//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends

class Activity
{
    int start; 
    int end;
    public Activity(int start,int end){
        this.start=start; 
        this.end=end; 
    }
    
    public void print(){
        System.out.println("Start :"+this.start);
        System.out.println("End :"+this.end);
    }
}
class ActivityComparator implements Comparator<Activity>
{
  
    public int compare(Activity a1,Activity a2){
        if(a1!=null && a2!=null && a1.end>a2.end) {
            //System.out.println(a1.end+" "+a2.end);
            return 1;
        }
        else if(a1.end==a2.end){
            return 0;
        }
       
       
        return -1;
    }
  
}
class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Activity> activities=new ArrayList<Activity>(); 
        for( int i=0;i<n;i++ ){
            
            activities.add(new Activity(start[i],end[i]));
        }
        Collections.sort(activities,new ActivityComparator());
        int count=0;
        int prev_end=0;
       if(activities.size()>0){
            count=1;
            prev_end=activities.get(0).end;
            
        }
        else
        {
            return count;
        }
        for(int i=1;i<n;i++){
            if(activities.get(i).start>prev_end) {
                prev_end=activities.get(i).end;
                count++;
            }
        }
       /* for(Activity i:activities){
            i.print();
        }*/
        return count;
    }
}
