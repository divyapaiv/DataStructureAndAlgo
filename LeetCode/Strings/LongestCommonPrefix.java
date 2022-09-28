
/*https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 */
class LongestCommonPrefix {
    public int getShortestLength(String[] str){
      
        int minlength=str[0].length();
        for(int i=1;i<str.length;i++){
            if(str[i].length() < minlength)
                minlength=str[i].length();
        }
        return(minlength);
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String  result="";
          int j=1;
        String substring="";
        int minlength=getShortestLength(strs);
        System.out.println(minlength);
        for(int i=0;i<minlength;i++){
        substring=strs[0].substring(0,minlength-i);
        System.out.println(substring);
            for(j=1;j<strs.length;j++){
            if(strs[j].indexOf(substring)==0)
                    continue; 
                else 
                {
                    break;
                }
            }
            if(j==strs.length){
                result=substring;
                return result;
            }
        }
        
        return result;
    }
}