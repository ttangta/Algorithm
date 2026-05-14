import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        if(s == null || words == null || words.length == 0)return answer;
        // 단어의 개수
        int m = words.length;
        // 단어 하나의 길이
        int n = words[0].length();
        int total = m*n;

        // words의 빈도수 맵
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word : words)wordMap.put(word, wordMap.getOrDefault(word, 0)+1);

        // 해당 부분을 구현하지 못함
        for(int offset = 0; offset < n; offset++){
            Map<String, Integer> window = new HashMap<>();
            int left = offset;
            // 빈도까지 일치하는 단어 수
            int match = 0;
            for(int right = offset; right + n <= s.length(); right+=n){
                // 오른쪽 단어 추가
                String word = s.substring(right, right+n);
                if(wordMap.containsKey(word)){
                    window.put(word, window.getOrDefault(word, 0)+1);
                    if(window.get(word).equals(wordMap.get(word))){
                        match++;
                    }else if(window.get(word).equals(wordMap.get(word)+1)){
                        match--;
                    }
                }

                // 윈도우가 넘치면 왼쪽 단어 제거
                if(right - left >= total){
                    String leftWord = s.substring(left, left+n);
                    if(wordMap.containsKey(leftWord)){
                        if(window.get(leftWord).equals(wordMap.get(leftWord))){
                            match--;
                        }else if(window.get(leftWord).equals(wordMap.get(leftWord)+1)){
                            match++;
                        }
                        window.put(leftWord, window.get(leftWord)-1);
                    }
                    left += n;
                }
                if(match == wordMap.size())answer.add(left);
            }
        }


        return answer;
    }
}