import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] command = new String[m];
        for(int i=0; i<m; i++)command[i] = br.readLine();
        System.out.println(solution(n, command));
    }
    private static String solution(int n, String[] command){
        int[] arr = new int[n+1];
        for(int i=0; i<=n; i++)arr[i] = i;
        
        for(String s : command){
            String[] cmd = s.split(" ");
            int i = Integer.parseInt(cmd[0]);
            int j = Integer.parseInt(cmd[1]);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++)sb.append(arr[i]).append(" ");
        return sb.toString().trim();
    }
}