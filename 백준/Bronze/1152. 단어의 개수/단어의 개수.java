import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력값을 공백을 구분자로 분리해 st 변수에 저장
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        //st변수에 저장된 개수를 출력
        System.out.println(st.countTokens());

    }

}