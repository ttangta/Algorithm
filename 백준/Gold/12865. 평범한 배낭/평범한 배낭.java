import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] info = new int[n+1][2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++){
            int weight = info[i][0];
            int value = info[i][1];
            for(int j=0; j<=k; j++){
                if(j >= weight){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[n][k]);
    } 
   
}