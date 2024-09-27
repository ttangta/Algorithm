import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] S = new int[N + 1];
		int[] D = new int[N + 1];
		st = new StringTokenizer(bf.readLine());
		for(int i=1 ; i<=N ; i++) {
			S[i] = Integer.parseInt(st.nextToken());	// 점수배열 만들기
		}
		for(int i=1; i<=N; i++) {
			D[i] = D[i-1] + S[i];						// 합배열 만들기
		}
		for(int i =0 ; i<M ; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(D[end] - D[start-1]);	// * 공식 합배열[end] - 합배열[start-1] == 점수배열 start 에서 end 까지의 요소합
		}
	}
}