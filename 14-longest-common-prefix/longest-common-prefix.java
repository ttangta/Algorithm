class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)return strs[0];
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
            String s = strs[i];
            for(int j=prefix.length()-1; j>=0; j--){
                if(!s.startsWith(prefix)){
                    prefix = prefix.substring(0, j);
                }else break;
            }
        }
        return prefix;
    }
}   