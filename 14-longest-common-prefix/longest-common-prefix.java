class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 만약 strs의 요소가 1개 밖에 존재하지 않으면 해당 요소 자체가 접두사이므로 바로 리턴
        if(strs.length == 1)return strs[0];

        // strs의 첫 번째 요소를 최초 접두사로 가정
        String prefix = strs[0];

        // strs의 두번째 요소 부터 최초 접두사와 비교하여 일치하지 않는 부분 잘라냄
        for(int i=1; i<strs.length; i++){
            String s = strs[i];
            // prefix의 길이만큼 반복하면서 i번째 s가 prefix로 시작하면 종료 그렇지 않으면 prefix의 가장 뒤의 문자부터 하나씩 잘라냄
            for(int j=prefix.length()-1; j>=0; j--){
                // 만약 i번째 s가 최초 prefix로 시작하지 않으면 prefix의 뒷 문자 하나씩 제거
                if(!s.startsWith(prefix))prefix = prefix.substring(0, j);
                // 일치한다면 반복 중지 - 현재까지 잘라낸 문자를 접두사로 사용
                else break;
                // j가 0일때 i번째 문자와 prefix 수정 동안 일치하는 부분이 없는 것 즉, 접두사가 존재하지 않음으로 바로 빈문자열 리턴
                if(j == 0)return "";
            }
        }
        return prefix;
    }
}