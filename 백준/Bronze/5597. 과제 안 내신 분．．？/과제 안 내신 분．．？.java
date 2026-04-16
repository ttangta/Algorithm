import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<28; i++){
            sb.append(br.readLine());
            sb.append("\n");
        }
        System.out.println(solution(sb.toString()));
    }
    private static String solution(String students){
        int[] student = new int[31];
        int[] num = Arrays.stream(students.split("\n")).mapToInt(Integer::parseInt).toArray();
        for(int x : num)student[x] = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=30; i++)if(student[i] != 1)sb.append(i).append("\n");
        return sb.toString();
    }
}