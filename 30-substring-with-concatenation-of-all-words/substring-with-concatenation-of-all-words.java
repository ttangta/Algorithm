import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        if(s == null || words == null || words.length == 0)return answer;

        int m = words.length;
        int n = words[0].length();
        int total = m * n;

        Map<String, Integer> wordsMap = new HashMap<>();
        for(String word : words)wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);

        for(int offset = 0; offset < n; offset++){
            int left = offset;
            int match = 0;
            Map<String, Integer> window = new HashMap<>();
            for(int right = offset; right + n <= s.length(); right+=n){
                String rightWord = s.substring(right, right+n);
                if(wordsMap.containsKey(rightWord)){
                    window.put(rightWord, window.getOrDefault(rightWord, 0)+1);
                    if(window.get(rightWord).equals(wordsMap.get(rightWord)))match++;
                    else if(window.get(rightWord).equals(wordsMap.get(rightWord)+1))match--;
                }

                if(right - left >= total){
                    String leftWord = s.substring(left, left+n);
                    if(wordsMap.containsKey(leftWord)){
                        if(window.get(leftWord).equals(wordsMap.get(leftWord)+1))match++;
                        else if(window.get(leftWord).equals(wordsMap.get(leftWord)))match--;
                        window.put(leftWord, window.get(leftWord)-1);
                    }
                    left += n;
                }
                if(match == wordsMap.size())answer.add(left);
            }
        }
        return answer;
    }
}