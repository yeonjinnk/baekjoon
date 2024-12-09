import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.SelectableChannel;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][]  visited;

    static int startX, startY, endX, endY;
    static int length;

//    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    static int result;
    static Queue<Point> q;

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        for(int i = 0; i < testCases; i++) {
            length = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이

            //시작 좌표 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken()); //현재 칸의 x
            startY = Integer.parseInt(st.nextToken()); //현재 칸의 y

            //목표 좌표 입력
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            q.offer(new Point(startX, startY)); //시작 좌표 큐에 삽입

            map = new int[length][length]; //체스판 초기화
            visited = new boolean[length][length]; //BFS를 위한 큐 초기화
            result = 0;
            bfs();

            System.out.println(map[endX][endY]);
        }

    }

    private static void bfs() {
        while(!q.isEmpty()) {
            Point now = q.poll(); //현재 위치를 큐에서 꺼냄
            if(now.x == endX && now.y == endY) return; //목표 도달 시 종료

            for(int i = 0; i < 8; i++) {
                int nx = now.x + dx[i]; //나이트가 이동할 새로운 x 좌표
                int ny = now.y + dy[i]; //나이트가 이동할 새로운 y 좌표

                //체스판의 범위를 벗어날 경우, 방향 전환
                if(nx < 0 || nx > length - 1 || ny < 0 || ny > length - 1) continue;
                if(map[nx][ny] == 0) { //아직 방문하지 않은 칸이라면
                    q.offer(new Point(nx, ny)); //큐에 새 좌표 추가
                    map[nx][ny] = map[now.x][now.y] + 1; //이동 횟수 기록
                }
            }
        }

    }




}