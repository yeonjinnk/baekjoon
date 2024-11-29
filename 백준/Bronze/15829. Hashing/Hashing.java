
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /* [요구 사항]
        입력 : 문자열 길이 L, 문자열
        출력 : 계산한 해시 값(정수)

        [해결 과정] 해시맵(1차 1~26)
        해시맵(거듭제곱과 곱하기)
        해시맵(나누기)

        [슈도 코드]
        입력받은 길이 저장할 변수 l 선언
        입력받은 문자열 저장할 변수 str 선언
        str을 char배열로 쪼갬
        char배열 각 index마다 숫자로 변환
        또 index마다 숫자*r의 거듭제곱으로 하고
        m으로 나누자..

        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());

        String str = br.readLine();

        Map<Character, Integer> alphaMap = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            alphaMap.put((char)('a' + i), i + 1);
        }
//        System.out.println(alphaMap);
        ArrayList<Integer> list = new ArrayList<>();
        for(char ch : str.toCharArray()) {
            list.add(alphaMap.get(ch));
        }

//        System.out.println(list);
        int r = 31;
        int M = 1234567891;
        int sum = 0;
       for(int i = 0; i < list.size(); i++) {
           list.set(i, (int)(list.get(i) * Math.pow(r, i)));
           sum += list.get(i);
       }
//        System.out.println(list);
        System.out.println(sum);

//        System.out.println(sum / M);


    }
}
