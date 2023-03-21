class Solution {
    public List<Integer> majorityElement(int[] nums) {
         int ele1=-1,ele2=-1,cnt=0,cnt2=0;
        for(int i=0;i<nums.length;i++){
          
            if(ele1==nums[i]){
               // ele1=nums[i];
                cnt++;
            }
            else if(ele2==nums[i]){
                // ele2=nums[i];
                cnt2++;
            }
            else if(cnt==0){
               ele1=nums[i];
               cnt++;
            }
            else if(cnt2==0){
                ele2=nums[i];
                cnt2++;
            }
            else{
              cnt2--;
              cnt--;  
               
                
            }
            
           
           

        }

        cnt=0;cnt2=0;
         ArrayList<Integer> res=new  ArrayList<Integer> ();
         for(int i=0;i<nums.length;i++){
             if(ele1==nums[i]){
                 cnt++;
             }
             else if(ele2==nums[i]){
                 cnt2++;
             }
         }
       //  System.out.println(ele1 + " "+cnt) ;
       //   System.out.println(ele2 + " "+cnt2) ;
         if(cnt>(nums.length/3)) res.add( ele1);
         if(cnt2>(nums.length/3)) res.add( ele2);
         return res;
    }
}
