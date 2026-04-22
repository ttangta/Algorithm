class Solution {
    public int reverse(int x) {
        // 매개변수 x를 먼저 Long 자료형을 통해 역순의 값을 가져와봄
        long reverse = 0;
        
        // 매개변수 x의 값을 String 자료형으로 변환 후 변환된 문자열의 마지막 인덱스 값부터 꺼내오며 answer의 값 갱신
        String sn = String.valueOf(x);

        // x가 음수일 경우 먼저 '-' 부호를 제거한 상태에서 정수 계산부터 진행
        sn = sn.replace("-","");
        for(int i=sn.length()-1; i>=0; i--){
            reverse = reverse * 10 + Integer.parseInt(String.valueOf(sn.charAt(i)));
        }

        // reverse의 값이 int 자료형으로 표현 가능한 범위인지 확인
        if(reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE)return 0;

        // reverse가 int 자료형으로 표현 가능한 범위인 경우 reverse의 반환 타입으로 변환한 변수 생성
        int answer = (int)reverse;

        // 메서드 호출 시 매개변수 x가 0보다 작으면 즉, 음수인 경우 answer * -1을 통해 음수로 반환
        return x<0?answer * -1:answer;
    }
}