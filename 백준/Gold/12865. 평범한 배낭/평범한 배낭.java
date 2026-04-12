import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] products = new int[n+1][2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, k, products));
    }
    
    private static int solution(int n, int k, int[][] products){
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++){
            for(int j=0; j<=k; j++){
                if(j >= products[i][0])dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-products[i][0]] + products[i][1]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][k];
    }
}