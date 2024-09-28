import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 1;	// start_index = 1 end_index = 1 일경우
		int count = 1;	// N이 선택될 경우 미리 설정
		int start_index = 1;
		int end_index = 1;
		while(end_index != N) {
			if(sum == N) {
				count++;
				end_index++;
				sum = sum + end_index;
			}else if(sum < N) {
				end_index++;
				sum = sum + end_index;
			}else if(sum > N) {
				sum = sum - start_index;
				start_index++;
			}
		}
		System.out.println(count);
}
}