import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> userWord = new HashSet<>();

        // 이전 단어의 마지막 글자 (최초 상태는 첫 번째 사람의 단어 첫 번째 글자로 초기화)
        char prevWord = words[0].charAt(0);

        for(int i=0; i<words.length; i++){
            // 이미 사용한 단어이거나 첫 글자가 이전 단어와 일치하지 않으면
            if(userWord.contains(words[i]) || words[i].charAt(0) != prevWord){
                return new int[]{(i%n)+1, (i/n)+1};
            }
            userWord.add(words[i]);
            prevWord = words[i].charAt(words[i].length() -1);
        }

        return new int[]{0,0};
    }
}