import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //input
        //1 1
        //2 3
        //3 4
        //9 8
        //5 2

//        //입력값이 많으므로 BufferedReader, 공백 숫자 분리를 위해 StringTokenizer 활용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str;

        //행이 존재할 때(null이 아닐동안) 공백으로 구분된 숫자를 a, b에 저장
        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }

//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println(sb);
//        bw.wrte(sb);
        //EoF(End of File) 입력을 위해, ctrl + d를 입력해 종료
    }

}