import java.util.*;
import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {
        //문제 분석
        //테스트 케이스 별 학교이름과 술의 양 주어짐
        //테스트 케이스 별 술의 양 가장 많은 학교 이름 출력 문제

        //문제 접근
        //계수 정렬 이용



        //입력
        //테스트 케이스 숫자 T,
        //  - 학교 숫자 N(1~100)
        //  - 학교이름 S(1~20), 술의 양 L(0~10,000,000)
        //  * 각 케이스 안에서 술의 양L 다 다름

        //출력
        //각 케이스마다 술 소비가 가장 많은 학교 이름 출력

        //1. 테스트 케이스 T 저장
        //2. 반복문(T만큼)
        //  학교 숫자 N 저장
        //      3. 반복문(N만큼)
        //          학교 이름 schoolName, 술의 양 L 저장
        //          L을 정렬해서 최대


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
//            System.out.println("N" + N);
            Map<Integer, String> map = new HashMap<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
//                System.out.println("s=" + s);
                int L = Integer.parseInt(st.nextToken());
                map.put(L, s);
                if(!maxHeap.isEmpty() && maxHeap.peek() < L) {
                    maxHeap.poll();
                    maxHeap.add(L);
                } else {
                    maxHeap.add(L);
                }
            }
            bw.write(map.get(maxHeap.peek()) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
