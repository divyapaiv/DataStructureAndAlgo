class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int []prof=new int[n];
        if(n==1) return(arr[0]);
        if(n==2) return(Math.max(arr[0],arr[1]));
        prof[0]=arr[0];
        prof[1]=arr[1];
        
        for(int i=2;i<n;i++){
            if(i-3>=0)
                prof[i]=Math.max(prof[i-2]+arr[i],prof[i-3]+arr[i]);
            else
                prof[i]=prof[i-2]+arr[i];
            
        }
        //System.out.println(Arrays.toString(prof));
        return Math.max(prof[n-1],prof[n-2]);
    }
}
