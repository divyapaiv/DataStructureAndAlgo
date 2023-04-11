
//Happiest Triplet O(NLOGN)
//User function Template for Java

class Solution
{
    int getMin(int x,int y,int z){
        if(x<=y && x<=z) return x;
        if(y<=x && y<=z) return y;
        else return z;
    }
    int getMax(int x,int y,int z){
        if(x>=y && x>=z) return x;
        if(y>=x && y>=z) return y;
        else return z;
    }
    ArrayList<Integer> smallestDifferenceTriplet(int a[],int b[],int c[],int n)
    {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int i=0,j=0,k=0;
        ArrayList<Integer> result=new ArrayList<Integer>();
        int curmin=Integer.MAX_VALUE;
        int overallmin=Integer.MAX_VALUE;
        while(i<a.length && j<b.length && k<c.length){
            int minval=getMin(a[i],b[j],c[k]);
            int maxval=getMax(a[i],b[j],c[k]);
            curmin=maxval-minval;
            if(curmin<overallmin){
               //  System.out.println(overallmin+" "+result+" "+minval+" "+maxval);
                result.clear();
                overallmin=curmin;
                result.add(a[i]);
                result.add(b[j]);
                result.add(c[k]);
            }
           
            if(minval==a[i]) i++;
            else if(minval==b[j]) j++;
            else if(minval==c[k]) k++;
            
        }
       Collections.sort(result,Collections.reverseOrder());
        return result;
        
    }
}
