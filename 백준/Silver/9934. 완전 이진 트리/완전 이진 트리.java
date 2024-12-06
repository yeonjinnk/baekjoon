import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.SelectableChannel;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int K;
    static List<Integer> tree;
    static List<Integer> [] treePrint;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            tree.add(Integer.parseInt(st.nextToken()));
        }

        //깊이랑 해당 레벨의 노드들을 저장
        treePrint = new ArrayList[K];

        for(int i = 0; i < treePrint.length; i++) {
            treePrint[i] = new ArrayList<>();
        }

        solution(0, 0, tree.size() - 1);

        for(List<Integer> tree : treePrint) {
            for(int node : tree) {
                System.out.print(node + " ");
            }
            System.out.println();
        }



    }

    static void solution(int depth, int start, int end) {
        //중간 노드가 현재레벨
        int n = (int) Math.floor((double)(start + end) / 2);

        //해당 level에 노드 추가
        treePrint[depth].add(tree.get(n));

        //처음과 끝이 같으면 순회 끝!
        if(end == start) {
            return;
        }

        solution(depth + 1, start, n - 1);
        solution(depth + 1, n + 1, end);
    }
}