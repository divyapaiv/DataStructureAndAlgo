/*1578. Minimum Time to Make Rope Colorful
https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] 
is the color of the ith balloon.

Alice wants the rope to be colorful.
 She does not want two consecutive balloons to be of the same color, 
 so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. 
 You are given a 0-indexed integer array neededTime where neededTime[i] 
 is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

Return the minimum time Bob needs to make the rope colorful.
*/

/* Algorithm 
For each balloon compare current and previous ballon color. 
	if color(N-1) == color(N) 
		Add minimum of time to mintime
		set current value of neededTime index to 
		maximum of time as we might need it in case if we have one more duplicate
		return mintime*/
		
class MinTimeBalloon {
    public int minCost(String colors, int[] neededTime) {
        int mintime=0;
        
        for(int i=1;i<neededTime.length;i++){
            if(colors.charAt(i)==colors.charAt(i-1))
            {
                mintime=mintime+Math.min(neededTime[i],neededTime[i-1]);
                neededTime[i]=Math.max(neededTime[i],neededTime[i-1]);
                System.out.println( neededTime[i]);
            }
        }
        return(mintime);
    }
}