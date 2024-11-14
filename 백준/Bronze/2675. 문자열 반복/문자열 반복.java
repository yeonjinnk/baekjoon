import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //입력, 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //첫 줄 테스트 케이스 개수
        int testCount = Integer.parseInt(br.readLine());

        //각 줄의 반복 횟수와 문자열을 공백으로 구분하기 위해
        StringTokenizer tokenizer;

        //입력된 각 줄을 읽어와서 저장할 str 변수
        String str = br.readLine();

        //각 줄이 null을 만날 때까지 반복
        for(int k = 0; k < testCount; k++) {
//        while((str = br.readLine()) != null) {
//            System.out.println(str);
            tokenizer = new StringTokenizer(str, " "); //공백으로 구분
            int repeatNum = Integer.parseInt(tokenizer.nextToken()); //공백으로 구분된 token 처음이 반복횟수
            char[] tokenArr = tokenizer.nextToken().toCharArray(); //문자열로 된 token을 문자배열로 변환

            //문자배열 각 i(index)에 대해 j번(repeatNum) 문자를 반복, 이중 for문
            for(int i = 0; i < tokenArr.length; i++) {
                for(int j = 0; j < repeatNum; j++) {
                    bw.write(tokenArr[i]);
                }
            } //각 줄 문자 반복하는 for문 끝
            bw.write("\n");
            bw.flush(); //출력문 버퍼에 저장
            str = br.readLine();
        } //각 줄 읽어오는 for문 끝
        br.close(); //입력 스트림 닫음
        bw.close(); //출력 스트림 닫음
    }

}