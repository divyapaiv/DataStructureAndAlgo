/* Time complexity = O(N) Space complexity =O(1)
https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
*/

class Solution {
    public int majorityElement(int[] nums) {
        int ele1=-1,ele2=-1,cnt=0,cnt2=0;
        for(int i=0;i<nums.length;i++){
            
            if(cnt==0){
                ele1=nums[i];
                cnt=1;
            }
            else if(ele1==-1 || ele1==nums[i]){
                ele1=nums[i];
                cnt++;
            }
            else{
                cnt--;
            }
           

        }
        cnt=0;
         for(int i=0;i<nums.length;i++){
             if(ele1==nums[i]){
                 cnt++;
             }
         }
         System.out.println(ele1);
         if(cnt>(nums.length/2)) return ele1;
         else return -1;
    }
}
