import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int v = Integer.parseInt(br.readLine());
        System.out.println(solution(n, numbers, v));
    }
    private static int solution(int n, String numbers, int v){
        return (int)Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).filter(num -> num==v).count();
    }
}