import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.SelectableChannel;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[][] map;
//    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

//    static int count;
    static Set<String> set;

    static String[] selected;
    static String str;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new String[5][5];
//        visited = new boolean[5][5];

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = String.valueOf(st.nextToken());
            }
        }

        set = new HashSet<>();
        selected = new String[6];
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(i, j, 0);
            }
        }


        System.out.println(set.size());

    }

    static void dfs(int x, int y, int depth) {
        if(depth == 6)  {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 6; i++) {
                sb.append(selected[i]);
            }
            set.add(sb.toString());
            return;
        }

        str += map[x][y];

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                selected[depth] = map[nx][ny];
                dfs(nx, ny, depth + 1);
            }
        }
    }
}