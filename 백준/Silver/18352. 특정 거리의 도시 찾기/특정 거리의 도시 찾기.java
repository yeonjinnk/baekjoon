import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int cityNum;
    static int[] distanceArr;
    static Queue<Integer> queue;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        cityNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int departNum = Integer.parseInt(st.nextToken());

        //인접리스트 초기화
        graph = new ArrayList[cityNum + 1]; //1~N번 도시까지
        for(int i = 1; i <= cityNum; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        //도로 정보 입력 받기
        for(int i = 1; i <= edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        //방문배열 초기값은 -1
        distanceArr = new int[cityNum + 1];
        Arrays.fill(distanceArr, -1);


        bfs(departNum);

        StringBuilder sb = new StringBuilder();

        boolean found = false;
        for(int i = 0; i < distanceArr.length; i++) {
            if(distanceArr[i] == distance) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if(!found) {
            sb.append("-1\n");
        }

        System.out.println(sb.toString());



    }


    private static void bfs(int start) {
        queue = new LinkedList<>();
        queue.offer(start); //queue에 초기값 저장
        distanceArr[start] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : graph[now]) {
                if(distanceArr[next] == -1) {
                    distanceArr[next] = distanceArr[now] + 1;
                    queue.add(next);
                }
            }


        }

    }


}