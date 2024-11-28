import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //입력 br, 출력 bw
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //큐
        Queue<Integer> queue = new ArrayDeque<Integer>();

        int n = Integer.parseInt(br.readLine());
        int last = 0;
        for(int i = 0; i < n; i++) {
            //각 줄을 읽어와서 왼쪽 토큰은 command에, push의 경우 오른쪽 토큰을 last에 저장
            //선입선출로 마지막 입력이 back에 쓰이므로 last로 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(st.hasMoreTokens()) {
                last = Integer.parseInt(st.nextToken());
            }
            switch(command) {
                //add: 뒤에 요소 추가. full일 때 예외 발생
                //offer: 뒤에 요소 추가, full일 때 false 반환
                case "push": queue.add(last); break;

                //remove: 맨앞 제거 후 반환. empty일 때 예외 발생
                //poll: 맨앞 제거 후 반환. empty일 때 null 반환
                case "pop": if(queue.isEmpty()) {
                    bw.write(-1 + "\n");
                    break;
                } else {
                    bw.write(queue.remove() + "\n");
                    break;
                }
                //write 메서드 파라미터는 문자열 또는 문자만 받음!!..
                case "size": bw.write(String.valueOf(queue.size()) + "\n"); break;
                case "empty": if(queue.isEmpty()) {
                    bw.write(1 + "\n");
                    break;
                } else {
                    bw.write(0 + "\n");
                    break;
                }

                //peek: 맨앞 요소 반환, empty시 null 반환
                    //element: 맨앞 요소 반환, 예외 발생
                case "front": if(queue.isEmpty()) {
                    bw.write(-1 + "\n");
                    break;
                } else {
                   bw.write(String.valueOf(queue.peek()) + "\n");
                    break;
                }
                case "back": if(queue.isEmpty()) {
                    bw.write(-1 + "\n");
                    break;
                } else {
                    bw.write(last + "\n");
                    break;
                }
            }

        }//for문 끝
        bw.flush();
        bw.close();
        br.close();

    }

}
