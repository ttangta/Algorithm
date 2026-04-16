import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(solution(n, str));
    }
    private static double solution(int n, String str){
        int[] scores = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(scores).max().getAsInt();
        double[] rescore = new double[n];
        for(int i=0; i<n; i++)rescore[i] = (double)scores[i]/max*100;
        return Arrays.stream(rescore).sum()/n;
    }
}