import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// A와 B는 공백 한 칸으로 구분
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		String sign;
		if(A > B)sign = ">";
		else if(A < B)sign = "<";
		else sign = "==";
		System.out.println(sign);
	}
}