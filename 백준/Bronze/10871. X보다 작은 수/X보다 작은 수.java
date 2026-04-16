import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        String numbers = br.readLine();
        System.out.println(solution(n, x, numbers));
    }
    private static String solution(int n, int x, String numbers){
        StringBuilder sb = new StringBuilder();
        int[] arr = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<n; i++){
            if(arr[i] < x)sb.append(arr[i]).append(" ");
        }
        return sb.toString().trim();
    }
}