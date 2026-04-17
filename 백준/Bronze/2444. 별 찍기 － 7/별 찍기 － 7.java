import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(br.readLine())));
    }
    private static String solution(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n-1; i++){
            sb.append(" ".repeat(n-i)).append("*".repeat((i*2)-1)).append("\n");
        }
        for(int i=n; i>=1; i--){
            sb.append(" ".repeat(n-i)).append("*".repeat((i*2)-1)).append("\n");
        }
        return sb.toString();
    }
}