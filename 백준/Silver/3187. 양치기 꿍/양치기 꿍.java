
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
늑대 v 양 k

양 > 늑대 양 win
양 <= 늑대 늑대 win

출력
살아남게 되는 양과 늑대의 수 각각 출력
* */
public class Main  {

    //행 수 R, 열 수 C, 결과값(양들 늑대들) sheeps wolves, 영역 내 양 sheep, 늑대 wolf 변수 각각 선언
    static int R, C, sheeps, wolves, wolf, sheep;

    static int[] Y = {-1, 1, 0, 0}; //y 상하좌우 방향 벡터
    static int[] X = {0, 0, -1, 1}; //x 상하좌우 방향 벡터

    static char[][] map;//영역 나타낼 2차원 배열 map 선언
    static boolean[][] visited; //방문 여부 체크할 2차원 배열 visited 선언

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 처리
        String str = br.readLine();

        // 행 수 R, 열 수 C 변수에 저장
        R = Integer.parseInt(str.split(" ")[0]);
        C = Integer.parseInt(str.split(" ")[1]);

        //map, visited 생성 RxC
        map = new char[R][C];
        visited = new boolean[R][C];

        //두번째 줄부터 입력받아 map, visited 초기화
        for(int y = 0; y < R; y++) {
            str = br.readLine();
            for(int x = 0; x < C; x++) {
                map[y][x] = str.charAt(x);
//                visited[y][x] = false;
            }
        }

        //#을 만나면
        for(int y = 0; y < R; y++) {
            for(int x = 0; x < C; x++) {
                //울타리이거나 방문한 곳은 무시
//                if(visited[y][x] || map[y][x] == '#') continue;
                if(visited[y][x]) continue;
                    //양과 늑대 수 초기화
                    wolf = 0;
                    sheep = 0;

                    //dfs 탐색
                    dfs(y, x);

                    //영역 내 많은 개체 수를 해당 종류 전체 개체 수에 추가
                    if(wolf >= sheep) {
                        wolves += wolf;
                    } else {
                        sheeps += sheep;
                    }
            }
        }
        //결과 출력
        System.out.println(sheeps + " " + wolves);

    }

    static void dfs(int y, int x) {
        //현재 위치 방문 처리
        visited[y][x] = true;

        //동물 종류 따라 동물 수 증가
        if(map[y][x] == 'k') sheep++;
        if(map[y][x] == 'v') wolf++;

        //상하좌우 4방향 탐색
        for(int i = 0; i < 4; i++) {
            int ny = y + Y[i];
            int nx = x + X[i];

            //경계 검사, 방문 여부 및 테두리 확인
            //아래 조건일 때, 해당 방향 탐색 중단 후 다음 방향 검사
            if(ny < 0 || nx < 0 || ny > R - 1 || nx > C - 1
                    || visited[ny][nx] || map[ny][nx] == '#') continue;

            //재귀 호출을 통해 다음 위치 탐색
            dfs(ny, nx);
        }
    }
}