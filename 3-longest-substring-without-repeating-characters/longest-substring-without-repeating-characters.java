import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0, left = 0;
        HashSet<Character> set = new HashSet<>();
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(set.contains(c)){
                while(set.contains(c)){
                    set.remove(s.charAt((left++)));
                }

            }
            set.add(c);
            answer = Math.max(answer, right-left+1);
        }
        return answer;
    }
}