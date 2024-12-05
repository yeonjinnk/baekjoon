import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
       #조건
       1. 쩰리는 가로와 세로의 칸 수가 같은 정사각형 내부에서만 움직일 수 있고, 여길 나가면 게임에서 패배함
       2. 출발점은 항상 왼쪽 가장 위의 칸임
       3. 이동 가능한 방향은 오른쪽과 아래뿐
       4. 오른쪽 가장 아래 칸에 도착하면 게임 승리
       5. 쩰리가 위치한 칸에 쓰여 있는 수만큼 이동해야함

       #접근방법
       이동 가능한 구역을 오른쪽 아래 하나하나 탐색하면서 끝 위치에 도달할 수 있는지 파악
       DFS(깊이우선탐색) 이용
       visited 배열을 통해 방문을 체크하고 해당 좌표에 다시 방문하지 못하도록 함

       #입력/출력
       첫번째 줄에는 게임 구역의 크기 N이 주어짐
       두번째 줄부터 마지막 줄까지 게임판의 맵이 주어짐
       게임판의 승리 지점에는 -1이 쓰여있고, 나머지 칸에는 0이상 100이하의 정수가 쓰여있음
       승리 지점에 도착하면 "HaruHaru", 아니면 "Hing"을 출력함
        */
public class Main  {
    //1. 입력값 저장할 2차원 배열 선언
    static int[][] map;

    //2. 방문여부 저장할 2차원 배열 선언
    static int[][] visited;

    //3. 게임판 크기 변수 선언
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 받기
        N = Integer.parseInt(br.readLine());

        //배열 생성 및 초기화
        map = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }

        boolean result = dfs(0, 0);
        System.out.println(result == true ? "HaruHaru" : "Hing");

    }

    //재귀함수
    static boolean dfs(int x, int y) {
        //게임판을 벗어나거나, 이미 방문한 곳이면 false 출력
        if((x < 0 || x > N - 1 || y < 0 || y > N - 1) || visited[x][y] == 1) {
            return false;
        }

        //현재 위치가 승리 지점(index의 마지막 위치)이면 true 출력
        if(x == N - 1 && y == N - 1) {
            return true;
        }

        //방문여부를 1로 표기
        visited[x][y] = 1;

        //이동을 위해 현재 위치 변수 jump 저장
        int jump = map[x][y];

        //탐색을 이어가기 위해, 재귀함수 호출 및 이동할 자리 더해줌.
        boolean moveRight = dfs(x + jump, y);
        boolean moveDown = dfs(x, y + jump);

        //둘 중 하나라도 true이면 true반환 false이면 false 반환
        if(moveRight || moveDown) {
            return true;
        } else {
            return false;
        }
    }


}

