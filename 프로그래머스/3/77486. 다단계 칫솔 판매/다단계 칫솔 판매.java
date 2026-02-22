import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> relation = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            relation.put(enroll[i], referral[i]);
        }
        
        HashMap<String, Integer> total = new HashMap<>();
        for(int i=0; i<seller.length; i++){
            String curName = seller[i];
            int money = amount[i]*100;
            while(money > 0 && !curName.equals("-")){
                total.put(curName, total.getOrDefault(curName, 0) + money - (money/10));
                curName = relation.get(curName);
                money /= 10;
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(String s : enroll)answer.add(total.getOrDefault(s, 0));
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}