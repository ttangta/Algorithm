import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subject = sc.nextInt();
		int[] score = new int[subject];
		int sum = 0;
		for(int i=0 ; i<subject ; i++) {
			score[i] = sc.nextInt();
			sum += score[i];
		}
		int max = score[0];
		
		for(int i = 0 ; i< score.length ; i++) {
			if(score[i] > max)max = score[i];
		}
		System.out.println(sum * 100.0 / max / subject);
	}
}