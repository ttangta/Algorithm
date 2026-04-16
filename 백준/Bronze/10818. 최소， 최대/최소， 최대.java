import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        System.out.println(solution(n, numbers));
    }
    private static String solution(int n, String numbers){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        int[] arr = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return sb.append(min).append(" ").append(max).toString();
    }
}