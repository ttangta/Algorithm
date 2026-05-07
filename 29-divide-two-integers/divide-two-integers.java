class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)return Integer.MAX_VALUE;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int answer = 0;
        while(a >= b){
            long temp = b;
            int shift = 0;
            while(a >= (temp<<1)){
                temp <<= 1;
                shift++;
            }
            a -= temp;
            answer += (1 << shift);
        }       
        boolean negative = (dividend > 0) ^ (divisor > 0);
        return negative?-answer:answer;
    }
}