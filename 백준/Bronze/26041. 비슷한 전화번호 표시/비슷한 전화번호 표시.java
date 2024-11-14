import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //입력, 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //공백으로 구분된 숫자
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //둘 째 줄에 있는 숫자를 String 타입 변수 preNum에 저장
        String preNum = br.readLine();
        
        //문자열 번호와 전호번호 차이를 크기로 판별 위해, 길이를 구함
        int preNumSize = preNum.length();
        
        //결과인 전화번호 개수 phoneCount로 선언
        int phoneCount = 0;

        //공백으로 구분된 문자열이 존재할 동안
        while(st.hasMoreTokens()) {
            String strA = st.nextToken();
            int strASize = strA.length();
            boolean isStartWith = strA.startsWith(preNum);
            
            //지정된 전화번호로 시작하면서 전화번호보다 사이즈가 큰 조건을 만족할 시, 개수 증가
            if(isStartWith && strASize > preNumSize) {
                phoneCount++;
            }
        }

        System.out.println(phoneCount);

    }

}