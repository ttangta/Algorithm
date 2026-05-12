class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 1){
            if(haystack.equals(needle))return 0;
            else return -1;
        }
        int answer = -1;
        int n = needle.length();
        for(int i = 0; i<=(haystack.length()-needle.length()); i++){
            char hc = haystack.charAt(i);
            if(hc == needle.charAt(0)){
                String com = haystack.substring(i, i+n);
                if(com.equals(needle))return i;
            }
        }

        return answer;
    }
}