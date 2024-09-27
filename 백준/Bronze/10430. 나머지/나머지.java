import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 조건 2<= A,B,C <= 10,000
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		System.out.println( (A+B)%C);
		System.out.println( ((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C) * (B%C))%C);
	}
}