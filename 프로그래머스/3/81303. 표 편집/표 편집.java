import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {

        // 삭제된 행의 인덱스를 저장하는 스택
        Stack<Integer> deleted = new Stack<>();

        // 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for(int i=0; i<n+2; i++){
            up[i] = i-1;
            down[i] = i+1;
        }

        // 현재 위치를 나타내는 인덱스 : 기존 테이블의 첫 번째 행 - 임시 공간이 생긴 새로운 테이블의 두 번째에 해당하기 때문에 초기 위치에는 +1
        k++;

        // cmd 배열의 요소를 하나씩 처리
        for(String c : cmd){
            if(c.startsWith("C")){
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            }
            else if(c.startsWith("Z")){
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            else{
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for(int i=0; i<x; i++){
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for(int i : deleted){
            answer[i-1] = 'X';
        }
        return new String(answer);
    }
}