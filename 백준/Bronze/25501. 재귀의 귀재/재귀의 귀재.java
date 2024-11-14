import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int count = 0; //함수 호출 횟수를 구해야 하므로, 정적변수로 선언

    public static void main(String[] args) throws IOException {

        //입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //첫 줄 숫자를 먼저 읽기
        br.readLine();

        //한 줄씩 읽어오는 문자열 저장할 변수 str
        String str;

        //각 행이 null이 아닐때까지 함수 반환값과 호출 횟수 구하기
        while((str = br.readLine()) != null) {
            bw.write(isPalindrome(str) + " " + count); //버퍼 안에 출력문 저장
            bw.write("\n"); //줄바꿈
            count = 0; //다음 문자열에 대한 횟수 초기화 위해
        }
        br.close(); //입력 스트림 닫음
        bw.flush(); //버퍼 안에 저장된 문자열 출력
        bw.close(); //출력 스트림 닫음

    }

    public static int recursion(String s, int l, int r){
        count++; //recursion 함수 호출 횟수 구하기 위해 메서드 호출시마다 count 증가
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

}