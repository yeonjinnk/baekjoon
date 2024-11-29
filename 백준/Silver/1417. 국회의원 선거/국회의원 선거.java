import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* [요구 사항] 입력 :
        후보의 수 N, 각각 1번, 2번, 3번 표의 수 출력
        : 1번이 뽑히기 위해 매수해야 할 사람의 수

        [해결 과정] 우선순위 큐를 통해 최대 힙으로 카운트를 줄여가며 구한다

        [슈도 코드] 입력값 차례대로 저장 최대힙 선언
        결과값 선언
        1번 후보의 표 저장
        N - 1번 반복하면서 최대힙에 데이터 삽입
        while (N의 크기 and 1번보다 클 때)
         최대힙에 팝하고 1번과 비교
         조건에 따른 연산 팝합
         값 - 1 푸시
         1번 표 수 1 증가
         카운트 증가
         결과값 출력 */

        Scanner sc = new Scanner(System.in);

        //입력값 차례대로 저장 최대힙 선언
        //후보 수 n
        int n = sc.nextInt();

        //결과값 선언
        int result = 0;

        //1번 후보의 표 저장
        int vote1 = sc.nextInt();

        // N - 1번 반복하면서 최대힙에 데이터 삽입
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < n - 1; i++) {
            maxHeap.add(sc.nextInt());
        }

       //while (N의 크기 and 1번보다 같거나 클 때)
        // 최대힙에 팝하고 1번과 비교
        while(n > 1 && maxHeap.peek() >= vote1) {

                // 조건에 따른 연산 팝합
                int max = maxHeap.remove();

                 //값 - 1 푸시
                maxHeap.add(max - 1);

                // 1번 표 수 1 증가
                vote1++;

                //카운트 증가
                result++;
        }

        //결과값 출력
        System.out.println(result);







    }


}
