import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    //문제분석
        //비밀번호는 원문자열과 뒤집어진 문자열이 존재
        //비밀번호 길이와 가운데 글자를 출력

        //뒤집어진 문자열이니까 sb의 reverse?
        //자료구조는 원문자열을 key로 받고 value에 뒤집어진 문자열 --> value에 딱히 저장할 값이 없음
        //--> 그냥 set으로 저장해서 contain 메서드로 판별하고 길이랑 중간값을 찾자!!
        //저장하고 value랑 key가 같으면

        //입력 숫자 n 저장
        //n만큼 순회

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            set.add(str);
            String reverse = new StringBuilder(str).reverse().toString();
            if(set.contains(reverse)) {
                int length = reverse.length();
                System.out.println(length + " " + reverse.charAt(length / 2));
            }
        }



    }

}
