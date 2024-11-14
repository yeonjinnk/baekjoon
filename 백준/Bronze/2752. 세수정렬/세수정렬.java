import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[3];
        for(int i = 0; i < 3; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(numArr);

        //출력
        System.out.println(numArr[0] + " " + numArr[1] + " " + numArr[2]);
        br.close();
    }
}