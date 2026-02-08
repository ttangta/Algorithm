import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 1. 판매원 - 추천인 형태의 HashMap 객체 생성
        HashMap<String, String> parent = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            parent.put(enroll[i], referral[i]);
        }
        
        // 2. 판매원 - 수익 형태의 HashMap 객체 생성
        HashMap<String, Integer> total = new HashMap<>();
        
        // 3. seller[i]의 실적에 대하여 해당 판매원의 추천인 관계를 올라가며 수수료 작업 후 total의 seller[i]의 값 저장
        for(int i=0; i<seller.length; i++){
            int money = amount[i] * 100;
            String curName = seller[i];
            
            while(money > 0 && !curName.equals("-")){
                total.put(curName, total.getOrDefault(curName, 0) + money - (money/10));
                curName = parent.get(curName);
                money /= 10;
            }
        }
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}