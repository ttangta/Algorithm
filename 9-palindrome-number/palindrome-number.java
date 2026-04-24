class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)return false;

        int clone = x;
        int reverse = 0;
        while(x != 0){
            reverse = reverse * 10 + (x%10);
            x /= 10;
        }

        return clone == reverse?true:false;
    }
}