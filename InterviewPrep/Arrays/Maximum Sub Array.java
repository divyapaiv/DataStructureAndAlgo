
class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        int maxsum=Integer.MIN_VALUE;
        int cursum=0;
        int start=0,maxstart=0;
        int maxend=0;
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            cursum+=a[i];
            if(a[i]<0){
                start=i+1;
                cursum=0;
            }
            if(cursum>maxsum){
                maxsum=cursum; 
                maxstart=start; 
                maxend=i;
            }
            else if(cursum==maxsum && (maxend-maxstart)<(i-start)){
                maxsum=cursum; 
                maxstart=start; 
                maxend=i;
            }
            
            
        }
        for(int i=maxstart;i<=maxend;i++){
            res.add(a[i]);
        }
        return res;
    }
}
