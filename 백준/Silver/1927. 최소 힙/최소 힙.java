import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        //문제분석
        //1. 배열에 자연수 x 삽입
        //2. 배열에 가장 작은 값을 출력하고, 제거

        //문제 접근
        // 가장 작은 값을 구하는 문제이므로 우선순위큐 사용

        //입력
        //연산의 개수 N(1~100,000)
        //x 자연수 -> x 추가
        //x 0 -> 가장 작은 값 출력, 제거

        //출력
        //0이 주어진 횟수만큼 답을 출력
        //배열이 비어있는 경우, 가장 작은 값 출력 0 출력

        //1. 입력값을 연산 개수 n 변수 선언 및 저장
        //2. 우선순위큐 선언 및 초기화
        //3. 반복문(n만큼 반복)
        // 입력값(변수 input)을 읽어가며 자연수일 때 큐에 추가, 그 외 작은 값 출력&제거

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        //1. 입력값을 연산 개수 n 변수 선언 및 저장
        int n = Integer.parseInt(br.readLine());

        //2. 우선순위큐 선언 및 초기화
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //3. 반복문(n만큼 반복)
        for(int i = 0; i < n; i++) {
            // 입력값(변수 input)을 읽어가며 자연수일 때 큐에 추가, 그 외 작은 값 출력&제거
            int input = Integer.parseInt(br.readLine());
            if(input > 0) {
                minHeap.add(input);
            } else {
                bw.write(minHeap.isEmpty() ? "0" : String.valueOf(minHeap.poll()));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();


    }
}
