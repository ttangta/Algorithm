import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//상대오차가 10-9 이하이면 정답이다. 
		Scanner sc = new Scanner(System.in);
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		System.out.println(A/B);
		// float duble => 정밀도
		// float => 소수점 6-7 자리 정도
		// double => 소수점 15-16자리 정도까지 표현 가능
		
		//TODO 코딩테스트에서 웬만한 조건이 붙어있는것이 아니라면 float보다 double 을 사용하는 게 더 좋다.
	}
}
