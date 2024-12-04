import java.util.*;
import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.DoubleStream;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            int applicant = Integer.parseInt(br.readLine());
            //일단 결과를 지원자 수 전원으로 설정하고, 조건에 맞지 않으면 감소
            int result = applicant;

            //서류와 면접을 map 자료구조로 저장
            //서류 성적 기준 오름차순 정렬 후, 해당 면접 성적이 이전 서류 순위 면접보다 가장 순위가 낮아야 save
            //클 경우 result --;

            /*
            1 4
            2 3 3이 4보다 크면 result --;
            3 2
            4 1
            5 5
             */
            TreeMap<Integer, Integer> map = new TreeMap<>();

            //map에 서류와 면접 성적 삽입
            for(int j = 0; j < applicant; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            //면접 성적은 서류 성적을 오름차순 정렬한 상태에서(treemap)
            //해당 value를 이전 index와 비교해야 하므로 배열로 저장
            int[] arr = new int[applicant];
            int index = 0;
            for(int value : map.values()) {
                arr[index++] = value;
            }

//            System.out.println(map);
//            System.out.println(Arrays.toString(arr));

            //초기 비교숫자 pivot

            int pivot = arr[0];
            //arr[0]은 서류에서 합격이므로 반복문 x

            //arr을 돌면서 pivot(서류 이전순위 면접전수) 보다 순위가 높으면
            //result--; pivot이 작다면 pivot도 변경
            for(int k = 1; k < arr.length; k++) {
                if(arr[k] > pivot) {
                    result--;
                } else {
                    pivot = arr[k];
                }
//                System.out.println(arr[k] + " " + result);
            }


            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

}
