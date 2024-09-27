import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 시험점수 범위 0 <= score <= 100
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		char grade;
		if(score>=90) {
			grade = 'A';
		}else if(score>=80) {
			grade = 'B';
		}else if(score>=70) {
			grade = 'C';
		}else if(score>=60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		System.out.println(grade);
	}
}