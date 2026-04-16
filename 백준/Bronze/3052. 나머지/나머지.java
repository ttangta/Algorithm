import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            sb.append(br.readLine());
            sb.append("\n");
        }
        System.out.println(solution(sb.toString()));
    }
    private static int solution(String numbers){
        int[] arr = new int[42];
        int[] num = Arrays.stream(numbers.split("\n")).mapToInt(Integer::parseInt).toArray();
        for(int x : num)arr[x%42]++;
        
        return (int)Arrays.stream(arr).filter(n -> n >=1).count();
        
    }
}