import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        int wordCount = words.length;
        int wordLen = words[0].length();

        Map<String, Integer> wordFreq = new HashMap<String, Integer>();
        for(String word : words)wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);

        for(int offset=0; offset<wordLen; offset++){
            int left = offset;
            int right = offset;
            int matched = 0;
            Map<String, Integer> windowFeq = new HashMap<>();
            while(right + wordLen <= s.length()){
                String rightWord = s.substring(right, right+wordLen);
                right+=wordLen;

                if(!wordFreq.containsKey(rightWord)){
                    windowFeq.clear();
                    matched = 0;
                    left = right;
                    continue;
                }

                windowFeq.put(rightWord, windowFeq.getOrDefault(rightWord, 0) + 1);
                matched++;

                while(windowFeq.get(rightWord) > wordFreq.get(rightWord)){
                    String leftWord = s.substring(left, left+wordLen);
                    windowFeq.put(leftWord, windowFeq.get(leftWord)-1);
                    if(windowFeq.get(leftWord) == 0)windowFeq.remove(leftWord);
                    matched--;
                    left += wordLen;
                }
                
                if(matched == wordCount)answer.add(left);
            }
        }

        return answer;
    }
}