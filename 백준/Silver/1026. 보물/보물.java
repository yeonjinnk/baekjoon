import java.util.*;
import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.DoubleStream;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        //각각 배열을 오름차순, 내림차순으로 정렬한 후 해당 index에서 곱해나가면 최소값
        //내림차순 배열 시, integer배열로 생성해야 에러가 없다!
        int[] arrA = new int[n];
        Integer[] arrB = new Integer[n];

        int index = 0;
        for(int i = 0; i < n; i++) {
            arrA[index] = Integer.parseInt(st.nextToken());
            arrB[index++] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        int result = 0;
        for(int i = 0; i < n; i++) {
            result += arrA[i] * arrB[i];
        }

        System.out.println(result);
    }




}
