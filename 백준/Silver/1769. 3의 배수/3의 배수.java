import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        입력받은 X에 대해, 각 자릿수의 합을 반복적으로 구하여 한 자리 수가 될 때까지 이 과정을 반복한다.
        이 과정에서 반복 횟수를 출력하고, 최종적으로 나온 한 자리 수가 3의 배수인지 아닌지를 판단하여 그 결과를 출력한다.

        1. 입력받은 값 X의 각 자리의 수를 더한 수 Y를 구함. (X가 1234567이라면 Y는 28가 됨)
        2. X의 각 자릿수를 더한 값을 새로운 숫자로 만들어 반복 (1234567 -> 28 -> 10 -> 1)
        3. 이 과정을 한 자리 숫자가 될 때까지 반복
        4. 이 변환 과정이 몇 번 이루어졌는지를 출력
        5. 최종적으로 나온 한 자리 수가 3의 배수이면 "YES", 아니면 "NO"를 출력

        #Pseudocode
        1. 입력값을 문자열 형태로 받는다.
        2. count 변수 0 으로 초기화
        3. 반복문 사용
         - 문자열의 길이가 1보다 클때까지 반복
           - 합의 변수 0 으로 초기화
           - 문자열 내 각 자릿수의 합을 구하고
           - 그 합을 문자열로 변환해서 다시 입력값으로 설정
           - count 횟수 1 증가시킴
        4. 구한 값이 3의 배수인지 확인한다.
        5. 변한 횟수 출력
        6. 구한 값이 3의 배수면 YES 출력, 아니면 NO 출력

         */

        //1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        //2. count 변수 0 으로 초기화
        int count = 0;

        //3. 반복문 사용
        // -3-1. 문자열의 길이가 1보다 클때까지 반복
        while(str.length() > 1) {
            // -3-2. 합의 변수 0 으로 초기화
            int sum = 0;

            // -3-3. 문자열 내 각 자릿수의 합을 구하고
            for(int i = 0; i < str.length(); i++) {
                sum +=  str.charAt(i) - '0';
            }

            //-3-4. 그 합을 문자열로 변환해서 다시 입력값으로 설정
            str = String.valueOf(sum);

            // -3-5. count 횟수 1 증가시킴
            count++;
        }

        //4. 변한 횟수 출력
        System.out.println(count);

        //5. 구한 값이 3의 배수인지 확인한다.
        //6. 구한 값이 3의 배수면 YES 출력, 아니면 NO 출력
        System.out.println(Integer.parseInt(str) % 3 == 0 ? "YES" : "NO");

    }

}
