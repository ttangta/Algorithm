import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 조건 1 <= A,B <= 10,000 int 자료형
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(A + B);
		System.out.println(A - B);
		System.out.println(A * B);
		// int / int => return 값 정수 (A 나누기 B)
		System.out.println(A / B);
		// int % int => return 시 A/B 의 나머지  (A 모듈 B)
		System.out.println(A % B);
	}
}