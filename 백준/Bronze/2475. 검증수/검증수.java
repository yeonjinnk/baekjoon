import java.util.Scanner;

public class Main {

	/*
	 * 문제 접근
	 * - 입력
	 * A B C D E (00000 ~ 99999)
	 * 
	 * - 출력
	 * 검증수(각 자리를 제곱한 수의 합을 10으로 나눈 나머지)
	 * 
	 */
	public static void main(String[] args) {
		/*
		 * 문제 해결
		 * 각 자리수마다 제곱하고 더해서 나머지를 구하는 문제
		 * 제곱하고 더하는 횟수가 5번 반복되므로 반복문을 사용
		 * 반복문 사용을 위해 숫자를 배열에 저장
		 * */
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); //입력값 a
		int b = sc.nextInt(); //입력값 b
		int c = sc.nextInt(); //입력값 b
		int d = sc.nextInt(); //입력값 b
		int e = sc.nextInt(); //입력값 b
		
		int sum = 0; //5개의 숫자를 제곱한 수의 합을 저장할 변수
		int[] numArr = {a, b, c, d, e};
		for(int i : numArr) {
			sum += i * i;
		}
		
		System.out.println(sum % 10);
		sc.close();
	}
}
