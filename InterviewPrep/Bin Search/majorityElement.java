class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
       // HashMap<Integer,Integer> cache=new HashMap<>();
        int curmax=1,curpos=0,count=0;
        for(int i=1;i<a.length;i++){
           if(a[i]==a[curpos]){
              curmax++; 
           }
           else{
               curmax--;
           }
            //System.out.println(curmax+" "+a[curpos]);
          if(curmax==0){
              curpos=i;
              curmax=1;
          }
        }
         for(int i=0;i<a.length;i++){
             if(a[curpos]==a[i]){
                 count++;
             }
         }
        //System.out.println(count+" "+a[curpos]);
     //  System.out.println(count+" "+(size/2));
        if(count>(size/2) ) return a[curpos]; 
        else if (count<=(size/2)) return -1;
        return -1;
    }
}
