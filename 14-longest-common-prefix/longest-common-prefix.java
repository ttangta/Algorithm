class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)return strs[0];
        String prefix = strs[0];
        A:for(int i=1; i<strs.length; i++){
            String s = strs[i];
            if(s.isEmpty())return "";
            for(int j=prefix.length(); j>=0; j--){
                if(s.startsWith(prefix))continue A;
                prefix = prefix.substring(0,j);
                if(prefix.isEmpty())return "";
            }
        }

        return prefix;
    }
}