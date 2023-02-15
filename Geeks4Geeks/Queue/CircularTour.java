//{ Driver Code Starts
/*
Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
*/
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}
// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
        
    // if the petrol-distance goes to 0 then we can not reach the destination using previous start.
    // if none of the past node was able to make it positive then they may not be able to be the start point 
    // keep prevpetrol to check if it was able to make distance positive with next set of petrols.
	int start=0;
	int sizevalue=petrol.length;
	int next=0;
	long curpetrol=0;
	long prevpetrol=0;
	while(next<sizevalue){
	    curpetrol+=petrol[next]-distance[next];
	    if(curpetrol<0){
	        prevpetrol+=curpetrol;
	        start=next+1;
	        curpetrol=0;
	    }
	    next++;
	}
	return((prevpetrol+curpetrol)>=0?start:-1);
    }
}
