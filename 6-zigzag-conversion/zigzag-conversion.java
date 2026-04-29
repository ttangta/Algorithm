class Solution {
    public String convert(String s, int numRows) {
        // 만약 numRows가 1인경우 하나의 행으로는 패턴을 적용자체를 할 수 없으므로 s 그대로 반환
        if(numRows == 1)return s;

        // 각 행에 배치된 문자를 담아둘 StringBuilder 객체 배열을 numRows 크기만큼 생성 및 초기화
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++)rows[i] = new StringBuilder();

        // 현재 행
        int current = 0;
        // 현재 행을 기준으로 다음번 이동의 방향을 정할 변수 최초 시작은 아래로 이동이기 때문에 1로 초기화
        int next = 1;

        // 문자열 s의 각 문자를 적절한 행에 배치
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            // 현재 행을 기준으로 다음번 이동 방향 결정
            // 현재 행이 젤 상단 행인 경우: 아래로 이동
            if(current == 0)next = 1;

            // 현재 행이 젤 하단 행인 경우 : 위로 이동
            if(current == numRows-1)next = -1;

            // 현재 행에 문자를 추가한 후 -> 현재 행을 다음 행으로 이동 
            rows[current].append(c);
            current+=next;
        }

        StringBuilder answer = new StringBuilder();
        for(StringBuilder sb : rows)answer.append(sb);
        return answer.toString();
    }
}