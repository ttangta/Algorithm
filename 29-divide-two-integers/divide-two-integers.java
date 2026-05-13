class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)return Integer.MAX_VALUE;
        int answer = 0;
        boolean negative = dividend < 0 ^ divisor < 0;
        
        long n1 = Math.abs((long)dividend);
        long n2 = Math.abs((long)divisor);
        while(n1 >= n2){
            long value = n2;
            long count = 1;
            while(n1 >= (value << 1)){
                value <<= 1;
                count <<= 1;
            }
            n1 -= value;
            answer += count;
        }

        return negative?-answer:answer;
    }
}