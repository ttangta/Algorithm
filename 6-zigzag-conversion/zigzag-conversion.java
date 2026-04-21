class Solution {
    public String convert(String s, int numRows) {
        // 행이 1인 경우 패턴 적용이 불가하기 때문에 원본 문자열 그대로 반환
        if(numRows == 1)return s;

        // 각 행의 문자 하나를 담아둘 StringBuilder() 객체를 모아둔 배열 생성 및 초기화
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++)rows[i] = new StringBuilder();

        // i번째 문자를 담을 행 -> 현재 문자의 행 값
        int currentRow = 0;
        // 현재행에서 다음 반복 시 이동할 행의 방향을 결정하는 변수
        int direction = 1;

        // s의 길이만큼 반복하면서 각 i번째 문자를 적절한 rows 위치의 객체에 누적
        for(int i=0; i<s.length(); i++){
            rows[currentRow].append(s.charAt(i));

            // 만약 현재 행이 최상단 행이라면 아래로 이동하도록 방향 지정 변수값 조정
            if(currentRow == 0)direction = 1;
            // 만약 현재 행이 최하단 행이라면 위로 이동하도록 방향 지정 변수값 조정
            else if(currentRow == numRows-1)direction = -1;

            // 현재 행에서 다음 행의 위치로 변경
            currentRow += direction;
        }
        // rows의 각 StringBuilder 객체가 담고있는 문자를 모두 합쳐서 정답 생성
        StringBuilder result = new StringBuilder();
        for(StringBuilder r : rows)result.append(r);
        return result.toString();
    }
}