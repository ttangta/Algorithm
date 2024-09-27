import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 조건 1 <= N <= 100
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=1 ; i<=N ; i++) {
			System.out.println("*".repeat(i));
		}
	}
}