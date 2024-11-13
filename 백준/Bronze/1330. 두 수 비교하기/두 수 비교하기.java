import java.util.Scanner;

public class Main {

	/*
	 * 문제 접근
	 * - 입력
	 * A B
	 * 
	 * - 출력
	 * A > B -> >
	 * A < B -> <
	 * A == B -> ==
	 * 
	 */
	public static void main(String[] args) {
		/*
		 * 문제 해결
		 * 경우에 따라 다르게 출력하고, 경우가 3가지 이므로
		 * 조건문 보다는 삼항연산자를 통해 계산
		 * */
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); //입력값 a
		int b = sc.nextInt(); //입력값 b
		
		String result = ""; //결과값을 출력할 변수
		result = (a > b) ? ">" : ((a == b) ? "==" : "<"); 
		
		System.out.println(result);
		sc.close();
	}

}
