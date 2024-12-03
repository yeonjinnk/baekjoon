import java.util.*;
import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {
        //삽질하느라 2시간 넘게 걸렸네..
        //2개 조합 뽑아서 하려고 했더니 math.random 써서 근데 그러면 몇번 돌려야 될지도 모르겠고
        //random이라 결국 최소 합이 안나오는 경우도 발생

        //그냥 오름차순으로 정렬해서 합을 구하고 합을 다시 넣어서 정렬 후 반복하는 문제였다..
        //후..


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> minHeap = new PriorityQueue<>();

            while (st.hasMoreTokens()) {
                minHeap.add(Long.parseLong(st.nextToken()));
            }
            long result = 0;
            while(minHeap.size() >= 2) {
                long a = minHeap.poll();
                long b = minHeap.poll();
                result += a + b;
                minHeap.add(a+b);
            }

            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
