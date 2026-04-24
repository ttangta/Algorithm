class Solution {
    public boolean isMatch(String s, String p) {
        // 패턴을 모두 확인한 이후 s가 남아있으면 매칭 실패, s가 비어있으면 매칭 성공
        if(p.isEmpty())return s.isEmpty();

        // s와 p의 첫 글자가 정확히 일치하거나 p의 값이 '.' 이면 매칭 성공
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0)=='.');

        // p의 문자가 "X*" 형태인 경우
        if(p.length() >= 2 && p.charAt(1) == '*'){
            // 두 가지 상황 존재
            // 1. 해당 패턴이 나타내는 문자 X가 0번 나타나나는 경우 -> p이동, s 그대로 유지
            // 2. 해당 패턴이 나타내는 문자 X가 1번 나타나는 경우 -> s 이동, p 그대로 유지
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)); 
        }
        // 단순 비교 후 각각 한 칸 씩 이동
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}