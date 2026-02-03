import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        int n = discount.length;

        HashMap<Integer, String> dayAndDcProduct = new HashMap<>();
        for(int i=0; i<n; i++){
            dayAndDcProduct.put(i+1, discount[i]);
        }

        HashMap<String, Integer> goal = new HashMap<>();
        for(int i=0; i<want.length; i++){
            goal.put(want[i], number[i]);
        }


        for(int i=1; i<=n-9; i++){
            HashMap<String, Integer> status = new HashMap<>();
            for(int j=i; j<=i+9; j++){
                String product = dayAndDcProduct.get(j);
                status.put(product, status.getOrDefault(product, 0) + 1);
            }

            boolean flag = true;
            for(int j=0; j<want.length; j++){
                String product = want[j];
                int num = number[j];
                if(!status.containsKey(product) || status.get(product)!=num){
                    flag = false;
                    break;
                }
            }
            if(flag)result++;
        }

        return result;
    }
}