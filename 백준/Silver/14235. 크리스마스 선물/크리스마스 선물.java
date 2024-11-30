import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //문제분석
        //1. 산타가 착한 아이에게 선물 나눠줌
        //2. 세계 거점에 선물 충전
        //3. 착한 아이 만날 때 가장 가치가 큰 선물 하나 선물
        //선물 가치 출력
        //줄 선물이 없으면 -1 출력

        //문제접근
        //충전한 선물 중 가장 큰 가치를 뽑으므로 maxHeap 사용

        //입력
        //첫번째 줄 : 아이들 및 거점지 방문 횟수 n(1~5,000)
        //그 다음 줄: 숫자개수 a와 a만큼 각각 선물의 가치(공백으로 구분)
        //          : 0이면 아이들을 만남

        //출력
        //a가 0일 때마다, 아이들에게 준 선물의 가치 출력
        //줄 선물이 없으면 -1 출력

        //0. 입력, 출력 스트림 선언
        //1. 입력값 n 변수 선언 및 저장
        //2. 우선순위큐 maxHeap 선언 및 초기화
        //3. 반복문(n만큼)
        //3-0. 입력 문자를 input String 변수에 선언 및 저장
        //3-1. 0이 아닌 숫자면(input 길이가 1 초과면) ? tokenizer로 maxHeap에 저장
        //3-2. 0이면? maxHeap에서 poll() 출력, 없으면 -1 출력

        //0. 입력, 출력 스트림 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer("");

        //1. 입력값 n 변수 선언 및 저장
        int n = Integer.parseInt(br.readLine());

        //2. 우선순위큐 maxHeap 선언 및 초기화
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        //3. 반복문(n만큼)
        //3-0. 입력 숫자를 input 변수에 선언 및 저장
        //3-1. 0이 아닌 숫자면 ? tokenizer로 maxHeap에 저장
        //3-2. 0이면? maxHeap에서 poll() 출력, 없으면 -1 출력
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if(input.length() > 1) {
                StringTokenizer st = new StringTokenizer(input);
                int tokenCount = Integer.parseInt(st.nextToken());
                for(int j = 0; j < tokenCount; j++) {
                    maxHeap.add(Integer.parseInt(st.nextToken()));
                }
            } else {
                bw.write(maxHeap.isEmpty() ? "-1" : String.valueOf(maxHeap.poll()));
                bw.newLine();
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
