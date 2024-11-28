import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //첫 줄에 해당 케이스 개수 N 주어짐
        //띄어쓰기 된 단어들의 리스트가 주어짐
        //단어 순서가 1 2 3 4 -> 4 3 2 1 로

        //DEQUE보다는 STACK이 성능상 낫지 않을까?

        //입력값의 수가 크지 않으므로 scanner, 스페이스바 구분자로 구분 st, 단어 저장할 stack, 출력 문자열 조합할 sb
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        //전체 케이스 개수 n
        int n = Integer.parseInt(sc.nextLine());

        //case문 출력 위해 1부터 시작~
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(sc.nextLine(), " ");

            //token이 존재할 동안 stack에 token 저장
            while(st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            sb.append("Case #" + i + ": ");

            //거꾸로 단어 조합
            while(!stack.isEmpty()) {
                sb.append(stack.pop() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

        }
}
