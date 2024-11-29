
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* [요구 사항]
        입력 : 숫자 A, B 마지막은 0 0
        출력 : A+B

        [해결 과정] 우선순위 큐를 통해 최대 힙으로 카운트를 줄여가며 구한다

        [슈도 코드]
        while 반복
        입력값 저장 변수 선언 a, b
        a+b 출력
        a, b 모두 0일 때 break
        */

        Scanner sc = new Scanner(System.in);
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 & b == 0) {
                break;
            }
            System.out.println(a + b);
        }

    }
}
