//Time Complexity NlogN
//Space Complexity Log N
class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        if(l<r){
            int p=partition(arr, l,  r, k);
            if(p==k-1){ return arr[k-1];
                
            }
            else if((p)<k-1){
                kthSmallest(arr, p,  r, k);
            }
            else{
                kthSmallest(arr, l,  p-1, k);
            }
        }
        return arr[k-1];
    
    }
    public static int partition(int[] a, int l, int r, int k) {
        int key=r;
        int h=r;
        int j=l;
     //   System.out.println("j"+j+" "+Arrays.toString(a));
        for(int i=l;i<=h;i++){
            if(a[i]<a[key]){
                int t=a[j];
                a[j]=a[i];
                a[i]=t;
                j++;
            }
        }
       
            int t=a[key];
            a[key]=a[j];
            a[j]=t;
        
        //System.out.println(a[key]+"j"+j+" "+Arrays.toString(a));
        return j;
        }
    
}
