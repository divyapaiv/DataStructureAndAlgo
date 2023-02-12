//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class ItemCompare implements Comparator<Item>{
    public int compare(Item i1,Item i2){
        if((i1.weight*i2.value)>(i2.weight*i1.value)) return 1;
        if((i1.weight*i2.value)==(i2.weight*i1.value)) return 0;
        return -1;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        double items=0.0;
        double count=0;
        Arrays.sort(arr,new ItemCompare());
        if(n<=0) return 0;
        for(int i=0;i<n;i++){
            count=0;
            if(arr[i].weight<=W){
                //System.out.println(arr[i].weight+" "+arr[i].value);
                //count=Math.floor((double)W/(double)arr[i].weight);
                //System.out.println(items);
                W=(int)W-(int)arr[i].weight;
                items=items+(arr[i].value);
               // System.out.println(items);
                
            }
            else
            {
                count=(double)(arr[i].value*(double)W)/(double)arr[i].weight;
                //System.out.println(count);
                items=items+count;
                W=0;
                break;
                
            }
            
        }
        return items;
        
    }
}
