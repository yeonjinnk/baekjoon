import java.util.Scanner;

public class Main {

	/*
	 * 문제 접근
	 * - 입력
	 * A B C D E ... N(1 ~ 100)
	 * 
	 * - 출력
	 * 별 출력(첫 줄 ~ 2*N -1)
	 * 
	 */
	public static void main(String[] args) {
		/*
		 * 문제 해결
		 * 입력 수의 2배 길이의 * 문자열을 만들고,
		 * 반복문을 통해 앞의 * 문자열 추출과 공백을 조합
		 * 뒷 문자열은 앞 문자열과 같으므로 똑같이 사용
		 * 
		 * 1 8 1
		 * 2 6 2
		 * 3 4 3
		 * 4 2 4
		 * 5 0 5
		 * 4 2 4
		 * 3 4 3
		 * 2 6 2
		 * 1 8 1
		 * */
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); //입력값 a
		String s = ""; // * 문자열 만들 변수 s
		for(int i = 1; i <= 2*a; i++) {
			s += "*"; //반복문을 돌며 * 문자열 생성
		}
		String begin = ""; //공백 앞, 뒤 문자열 begin
		String middle = ""; //공백 문자열 middle
		String star = ""; //한 줄에 해당하는 문자열 star
		for(int i = 1; i <= a; i++) {
			begin = s.substring(0, i); 
			for(int j = 1; j <= 2*a-2*i; j++) {
				middle += " ";
			}
			star = begin + middle + begin;
			System.out.println(star);
			middle = "";
		}
		
		for(int i = a - 1; i >= 1; i--) {
			begin = s.substring(0, i);
			for(int j = 1; j <= 2*a-2*i; j++) {
				middle += " ";
			}
			star = begin + middle + begin;
			System.out.println(star);
			middle = "";
		}
		sc.close();
	}
}