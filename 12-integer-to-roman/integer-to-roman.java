class Solution {
    public String intToRoman(int num) {
        int[] n = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            for(int i=0; i<n.length; i++){
                if(num - n[i] >= 0){
                    sb.append(roman[i]);
                    num -= n[i];
                    break;
                }
                else continue;
            }
        }
        return sb.toString();
    }
}