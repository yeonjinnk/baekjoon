import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //[문제분석]
        //1. 센티가 거인의 나라에 감
        //2. 거인의 나라에는 센티 키 이상이다
        //3. 뿅망치 맞으면 키 반토막 됨
        //4. 단, 1인 경우 뿅망치 효과 x
        //5. 뿅망치 횟수 제한
        //6. 그래서 키가 큰 거인 중 하나 때림
        //7. 모든 거인이 센티보다 작게

        //[문제전략]
        //우선순위 큐 내림차순 정렬(거인 키 저장)

        //반복문(뿅망치 제한 횟수만큼)
        //우선순위 peek와 센티 키 비교
        //센티가 더 크면 or peek가 1일 때 반복문 종료
        //pop 시키고 키 / 2를 add

        //큐의 peek과 센티 키 비교 -> 센티 큼 ? yes출력 & 거인 가장 큰 키 출력 : no출력

        //입력
        //첫 줄 :거인 나라 인구 수 n, 센티 키 h, 횟수 제한 t
        //두번째 줄 : n개 줄에 거인 키

        //출력
        // yes 출력
        // no 출력

        //1. 각 입력값 변수 선언 및 저장
        //거인 나라 인구 수 n, 센티 키 h, 횟수 제한 t 각각 변수 선언
        //n개 줄에 거인 키

        //2. 거인 키 저장할 큐 변수 선언
        //3. 큐에 거인 키 삽입(반복문 n만큼)
        //4. 뿅망치 최수 횟수 count 선언
        //5. 반복문(뿅망치 제한 횟수 t만큼)
        //        우선순위 peek와 센티 키 비교
        //       ( 센티 h가 더 크면 or peek가 1일 때 반복문 종료)
        //        pop 시키고 (키 / 2)를 add & count 증가

        //6. 큐의 peek과 센티 키h 비교 -> 센티 큼 ? yes출력 & 거인 가장 큰 키 출력 : no출력

        //1. 각 입력값 변수 선언 및 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //거인 나라 인구 수 n, 센티 키 h, 횟수 제한 t 각각 변수 선언
        //n개 줄에 거인 키
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        //2. 거인 키 저장할 큐 변수 선언
        //큰 키를 비교하니까, 내림차순
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        //3. 큐에 거인 키 삽입(반복문 n만큼)
        for(int i = 0; i < n; i++) {
            maxHeap.add(Integer.parseInt(br.readLine()));
        }

        //4. 뿅망치 최수 횟수 count 선언
        int count = 0;

        //5. 반복문(뿅망치 제한 횟수 t만큼)
        //        우선순위 peek와 센티 키 비교
        //       ( 센티 h가 더 크면 or peek가 1일 때 반복문 종료)
        //        pop 시키고 (키 / 2)를 add & count 증가
        for(int i = 0; i < t; i++) {
            if(maxHeap.peek() < h || maxHeap.peek() == 1) {
                break;
            }
            int max = maxHeap.poll();
            maxHeap.add(max / 2);
            count++;
        }

        //6. 큐의 peek과 센티 키h 비교 -> 센티 큼 ? YES 출력 & count출력  : NO 출력& 거인 가장 큰 키 출력
        if(maxHeap.peek() < h) {
            bw.write("YES" + "\n");
            bw.write(String.valueOf(count));
        } else {
//            bw.write("NO" + "\n");
            bw.write("NO");
            bw.newLine(); //줄바꿈
            //write는 String 타입에서만 동작!!
            bw.write(String.valueOf(maxHeap.poll()));
//            bw.write(maxHeap.poll());
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
