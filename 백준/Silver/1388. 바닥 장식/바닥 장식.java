import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main  {
    //1. 입력값 저장할 2차원 배열 선언
    static char[][] map;

    //2. 방문여부 저장할 2차원 배열 선언
    static int[][] visited;

    //3. 변수 선언
    static int N, M;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //배열 생성 및 초기화
        map = new char[N][M]; //6 9
        visited = new int[N][M];

        for(int y = 0; y < N; y++) {
            String str = br.readLine();
//            System.out.println(str);
            for(int x = 0; x < M; x++) {
                map[y][x] = str.charAt(x);
                visited[y][x] = -1;
//                System.out.print(map[y][x]);
            }
//            System.out.println();
        }
        result = 0;

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
//                System.out.printf("%d, %d \n", y, x);
                if(visited[y][x] == -1) {
                    dfs(y, x, map[y][x]);
                    result++;//재귀호출이 끝나서 return문으로 돌아오거나, 범위 끝나서 void 반환 시 result 증가
//                    System.out.println("result = " + result);

                }
            }
        }

//        for(int y = 0; y < N; y++) {
//            for(int x = 0; x < M; x++) {
//                System.out.print(visited[y][x]);
//            }
//            System.out.println();
//        }

        System.out.println(result);
//        boolean result = dfs(0, 0);
//        System.out.println(result == true ? "HaruHaru" : "Hing");

    }

    //재귀함수 현재 위치 x, y
    // '-' 이면 오른쪽
    // '|'이면 아래쪽

    static void dfs(int y, int x, char shape) {
//        System.out.printf(" - %d, %d, %c\n", y, x, shape);

        //재귀로 호출 후, 이전 모양과 다르면 호출자로 이동
        if(shape != map[y][x]) {
            return;
        }

        visited[y][x] = 1;

        if(shape == '-' && x + 1 < M) {
            dfs(y, x + 1, shape);

        }
        if(shape == '|' && y + 1 < N) {
            dfs(y + 1, x, shape);
        }

    }

}