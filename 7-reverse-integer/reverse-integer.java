class Solution {
    public int reverse(int x) {
        long answer = 0;
        while(x != 0){
            answer = answer * 10 + (x%10);
            if(answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE)return 0;
            x /= 10;
        }

        return x<0?(int)answer*-1:(int)answer;
    }
}