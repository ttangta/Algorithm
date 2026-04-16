import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<9; i++){
            sb.append(br.readLine());
            sb.append("\n");
        }
        System.out.println(solution(sb.toString()));
    }
    private static String solution(String numbers){
        int[] arr = Arrays.stream(numbers.split("\n")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE, maxIdx = 0;
        for(int i=0; i<9; i++){
            if(max < arr[i]){
                max = arr[i];
                maxIdx = i+1;
            }
        }
        return sb.append(max).append("\n").append(maxIdx).toString();
    }
}