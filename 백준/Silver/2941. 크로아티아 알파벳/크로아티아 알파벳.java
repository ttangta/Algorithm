import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));

    }
    private static HashMap<Character, ArrayList<String>> croatians;
    public static void makCroatians(){
        croatians = new HashMap<>();
        croatians.put('c', new ArrayList<>(List.of("c=", "c-")));
        croatians.put('d', new ArrayList<>(List.of("dz=", "d-")));
        croatians.put('l', new ArrayList<>(List.of("lj")));
        croatians.put('n', new ArrayList<>(List.of("nj")));
        croatians.put('s', new ArrayList<>(List.of("s=")));
        croatians.put('z', new ArrayList<>(List.of("z=")));
    }
    private static int solution(String str){
        int answer = 0;
        makCroatians();
        // 매개변수로 전달받아온 str에 대해 한 문자씩 비교
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            // c가 크로아티아 알파벳을 나타낸 문자일 가능성이 존재한 경우
            if(croatians.containsKey(c)){
                A: for(String s : croatians.get(c)){
                    boolean isCroatian = true;
                    // 해당 패턴 문자열을 문자 배열로 전환
                    char[] arr = s.toCharArray();
                    int idx = 0;
                    // 현재 i번 문자가 크로아티아 알파벳이 되기위한 조건
                    // 1. i번에서 크로아티아 알파벳 패턴의 길이를 더해봤을 때 전체 문자열의 길이보다 작거나 같아야 함
                    // 2. i번 문자 ~ i+패턴 문자열길이 만큼 범위 내가 모두 일치해야함

                    if(i+s.length() <= str.length()){
                        // str에서 패턴 비교해봐야할 범위 중에서 해당 패턴과 일치하지 않은 문자가 하나라도 존재하면 다음 패턴과 비교해봄
                        for(int j=i; j<i+s.length(); j++){
                            if(str.charAt(j) != arr[idx++]){
                                isCroatian = false;
                                continue A;
                            }
                        }
                        // 패턴과 일치한 경우 해당 범위는 하나의 문자로 봄 고로 다음 번 확인 문자의 위치 조정 필요
                        if(isCroatian){
                            i += s.length() -1;
                            break A;
                    }

                    }
                }
            }
            answer++;
        }

        return answer;
    }
}


