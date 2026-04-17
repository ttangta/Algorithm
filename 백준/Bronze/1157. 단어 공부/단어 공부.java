import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
    private static char solution(String str){
        str = str.toUpperCase();
        int[] arr = new int[26];
        for(char c : str.toCharArray())arr[c-65]++;
        
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i=0; i<26; i++){
            if(max < arr[i]){
                max = arr[i];
                idx = i;
            }
        }
            
        final int finalMax = max;
        int cnt = (int)Arrays.stream(arr).filter(n -> finalMax==n).count();
        return cnt>1? '?' : (char)(idx+65);
    }
} 