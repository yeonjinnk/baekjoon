import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.SelectableChannel;
import java.util.*;

public class Main {
    static int[] visited = new int[100001];
    static int subin;
//    static int[] dx = new int[3];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        int brother = Integer.parseInt(st.nextToken());



        if (subin == brother) {
            System.out.println(0);
        } else {
            bfs(subin, brother);
        }
    }

    static void bfs(int subin, int brother) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(subin);
        result = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i < 3; i++) {
                int nx;
                if(i==0) {
                    nx=now+1;
                }else if(i==1) {
                    nx=now-1;
                }else {
                    nx=now*2;
                }
                if (now == brother) {
                    System.out.println(visited[now]);
                    return;
                }

                if (nx >= 0 && nx < visited.length && visited[nx] == 0) {
//                    System.out.println(nx);
                    queue.add(nx);
                    visited[nx] = visited[now] + 1;
                }
            }
        }
    }

}