import java.util.*;
import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException{
        //문제분석
        //대기 학생 수 최대일 때 맨 뒤 대기중인 학생 번호 구하기

        //문제접근
        //선입선출 queue를 써보자..

        //입력
        //첫번째 줄 :n
        //다음 줄~n줄 : 하나의 정보(유형1, 2 중 하나)
        //* 1 a : 학생 번호 a가 맨 뒤에 줄 섬
        //* 2 : 식사 1인분이 준비되어 맨 앞 학생 식사 시작

        //출력
        //대기 학생수 최대일 때 학생 수, 맨 뒤 대기중인 학생 번호
        //* 최대가 여러 번일 때 맨 뒤 번호가 가장 작은 경우 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //마지막 줄 n
        int n = Integer.parseInt(br.readLine());

        //학생 저장할 자료구조 queue
        Deque<Integer> queue = new ArrayDeque<>();

        //대기 학생 수와 그 때 맨 뒤 학생 번호 저장
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int inOut = Integer.parseInt(st.nextToken());

            //inOut이 1일 때만 학생 번호 존재
            if(inOut == 1) {
                int num = Integer.parseInt(st.nextToken());
                queue.addFirst(num);

                int mapSize =queue.size();
                int peek = queue.peek();

                if(map.get(mapSize) != null) {
                    int minNum = map.get(mapSize);
                    map.put(mapSize, peek > minNum ? minNum : peek);
                } else {
                    map.put(mapSize, peek);
                }
            } else {
                queue.removeFirst();
            }
        }
        int max = 0;
        for(int i : map.keySet()) {
            max = i > max ? i : max;
        }
        bw.write(max + " " + map.get(max));
        bw.flush();
        bw.close();
        br.close();

    }

}
