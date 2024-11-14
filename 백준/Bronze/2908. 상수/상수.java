import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        Scanner sc = new Scanner(System.in);

        //공백으로 숫자 분리해서 strArr에 저장
        String[] strArr = sc.nextLine().split(" ");

        //뒤집은 숫자 reverseArr에 저장
        String[] reverseArr = new String[strArr.length];

        //strArr index를 뒤집어 조합
        for(int i = 0; i < strArr.length; i++) {
            String s = strArr[i];
            String reverseS = s.charAt(2) + "" + s.charAt(1) + s.charAt(0); //String 변환 위해 "" 조합
            reverseArr[i] = reverseS;
        }

        System.out.println(Math.max(Integer.parseInt(reverseArr[0]), Integer.parseInt(reverseArr[1])));


    }

}