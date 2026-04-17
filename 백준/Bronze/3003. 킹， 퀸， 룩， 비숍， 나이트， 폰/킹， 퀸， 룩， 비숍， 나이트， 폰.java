import java.util.*;
import java.io.*;
public class Main{
    private static final int[] base = {1,1,2,2,2,8};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
    private static String solution(String status){
        StringBuilder sb = new StringBuilder();
        int[] now = Arrays.stream(status.split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<base.length; i++){
            sb.append(base[i] - now[i]).append(" ");
        }
        return sb.toString();
    }
    
}