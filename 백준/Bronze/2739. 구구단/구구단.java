import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 조건 1 <= N <= 9
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1 ; i<=9 ; i++) {
			//System.out.println(N + " * " + i + " = " + N*i);
			System.out.printf("%d * %d = %d\n",N,i,(N*i));
		}
	}
}