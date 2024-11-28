import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //1. X는 3의 배수인가?(1,000,000 이하)
        //2. X의 각 자리수를 더한 수 Y는 3의 배수인가?
        //3. Y가 10 미만 될 때까지 반복
        //4. Y는 3의배수인지 판별

        //각 자리수를 더한 횟수를 구하기
        //최종 Y가 3의 배수인지

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine();
        int result = 0;
        int sum = 0;

        while(true) {
            if(x.length() == 1) break;

            sum = 0;
            for(int i = 0; i < x.length(); i++) {
                sum += Integer.parseInt(String.valueOf(x.charAt(i)));
            }
            x = String.valueOf(sum);
            result++;
        }

        System.out.println(result);
        System.out.println(Integer.parseInt(x) % 3 == 0 ? "YES" : "NO");
        br.close();
    }
}
