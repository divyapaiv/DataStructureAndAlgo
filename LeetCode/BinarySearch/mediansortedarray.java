class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int beg=0,end=0;
        int i1,i2,leftmax1,leftmax2,rightmin1,rightmin2;
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        end = nums1.length;
         //System.out.println(n2);
        
      
        while(beg<=end){
            int m = nums1.length;
            int n = nums2.length;
            i1=(beg+end)/2;
           
            i2=((m+n+1)/2)-i1;
          
            rightmin1 = (i1 == m)?Integer.MAX_VALUE:nums1[i1];
			leftmax1 = (i1 == 0)?Integer.MIN_VALUE:nums1[i1 - 1];
			System.out.println(i2+"\t "+n);
			rightmin2 = (i2 == n)?Integer.MAX_VALUE:nums2[i2];
		    leftmax2 = (i2 == 0)?Integer.MIN_VALUE:nums2[i2 - 1];
         // System.out.println(l1+"\t "+l2);
            //System.out.println(r1+"\t "+r2);
            if(leftmax1<=rightmin2 && leftmax2<=rightmin1){
                if((m+n)%2==0)
                    return (double)(Math.min(rightmin1,rightmin2)+Math.max(leftmax1,leftmax2))/2.0;
                else {
                    return (double)(Math.max(leftmax1,leftmax2));
                }
            }
            else if(leftmax1>rightmin2)
                end=i1-1; 
            else 
                beg=i1+1;
        }
        return -1;
    }
}
