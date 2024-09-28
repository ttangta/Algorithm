import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int count  = 1;
		int sum = 1;
		int start_index = 1;
		int end_index = 1;
		while(end_index != N) {
			if(sum == N) {
				// 결과가 입력값과 같을 경우
				count++;	// 가짓수 증가
				end_index++;// end_index 증가
				sum += end_index;
			}else if(sum < N) {
				// sum이 입력값보다 작을 경우
				end_index++;
				sum += end_index;
			}else if(sum > N) {
				// sum이 입력값보다 클 경우
				sum -= start_index;
				start_index++;
			}
		}
		System.out.println(count);
	}
}