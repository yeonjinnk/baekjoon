import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.SelectableChannel;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> map;
    static boolean[] visited;
    static int result;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pcNum = Integer.parseInt(br.readLine());
        int pcPair = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        for(int i = 0; i <= pcNum; i++) {
            map.add(new ArrayList<>());
        }

        visited = new boolean[pcNum + 1];

        for(int i = 0; i < pcPair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map.get(A).add(B);
            map.get(B).add(A);
        }

        dfs(1);

        System.out.println(result);

    }

    static void dfs(int node) {
        visited[node] = true;
        for(int i : map.get(node)) {
            if(visited[i] == false) {
                result++;

                dfs(i);
            }
        }
    }


}