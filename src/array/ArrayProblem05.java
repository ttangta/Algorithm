package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArrayProblem05 {
    public static void main(String[] args){
        System.out.println(solution("ULURRDLLU"));
    }


    private static int solution(String dirs){
        // 문자열의 각 문자마다 이동할 좌표값을 배열로 지정
        HashMap<Character, int[]> location = new HashMap<>();
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1,0});
        location.put('L', new int[]{-1,0});

        // 초기 시작 위치 지정
        int x = 0, y = 0;

        // 이동한 경로를 저장할 HashSet<String> 객체 생성, 한 번의 이동에 순방향, 역방향 경로 모두 저장
        // 처음 걸어본 길의 길이를 구하기 위해 중복값을 허용하지 않는 Set을 사용
        HashSet<String> movement = new HashSet<>();

        // 문자열의 길이만큼 반복문 시작
        for(int i=0; i<dirs.length(); i++){
            int[] move = location.get(dirs.charAt(i));
            int nx = x + move[0];
            int ny = y + move[1];
            // 유효하지 않는 좌표값을 가진 명령어의 경우 해당 명령어는 무시
            if(nx < 0 || nx > 5 || ny < 0 || ny > 5)continue;

            // 순방향 이동 문자열 (x,y) -> (nx,ny)
            String m1 = "(" + x + "," + y + ") -> (" + nx + "," + ny + ")";

            // 역방향 이동 문자열 (nx,ny) -> (x,y)
            String m2 = "(" + nx + "," + ny + ") -> (" + x + "," + y + ")";
            movement.addAll(List.of(m1, m2));

            // 시작 (x,y)의 값은 이동된 좌표의 값으로 변경
            x = nx; y = ny;
        }

        // 한 번의 이동에 순방향/역방향의 경로를 HashSet을 더했으므로 1이동 = 2가지 경로가 저장됨 = /2를 수행해야함
        return movement.size()/2;
    }
}
