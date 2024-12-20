import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //입력, 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //첫 줄 테스트 케이스 개수(반복문에 횟수로 사용 예정)
        int testCount = Integer.parseInt(br.readLine());

        //각 줄의 반복 횟수와 문자열을 공백으로 구분하기 위해
        StringTokenizer tokenizer;

        //테스트 케이스 개수(testCount)만큼 반복
        for(int k = 0; k < testCount; k++) {
            tokenizer = new StringTokenizer(br.readLine(), " "); //공백으로 구분자로 분리함

            int repeatNum = Integer.parseInt(tokenizer.nextToken()); //공백으로 구분된 token 처음이 반복횟수
            char[] tokenArr = tokenizer.nextToken().toCharArray(); //문자열로 된 token을 문자배열로 변환

            //문자배열 각 i(index)에 대해 j번(repeatNum) 문자를 반복, 이중 for문
            for(int i = 0; i < tokenArr.length; i++) {
                for(int j = 0; j < repeatNum; j++) {
                    bw.write(tokenArr[i]);
                }
            } //각 줄 문자 반복하는 for문 끝
            bw.write("\n"); 
            bw.flush(); //버퍼에 저장된 출력문 출력
        } //각 줄 읽어오는 for문 끝
        br.close(); //입력 스트림 닫음
        bw.close(); //출력 스트림 닫음
    }

}