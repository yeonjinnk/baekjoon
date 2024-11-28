
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //1. 높이가 다른 막대기 일렬로 게워짐
        //2. 오른쪽에서 봤을 때 마지막 번호 막대랑 마지막 번호보다 높은 막대가 관찰됨
        //3. 마지막 번호보다 높은 막대는 최대 1개만 관찰됨
        //4. 해당 개수를 구하는 문제

        //막대기를 자료구조에 저장(끝에서부터 제거하니까 stack)
        //오른쪽부터 막대기 꺼내며 막대기 최대 높이를 저장
        //막대기 돌면서 큰 게 나오면 개수 증가

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            //스택에 막대기 넣음
            stack.push(Integer.parseInt(br.readLine()));
        }

        //맨 오른쪽 막대기 max로 초기설정
        int max = stack.peek();

        //오른쪽 막대기 포함 최대 개수
        int result = 1;

        //stack에서 pop한 max보다 큰 정수를 임의로 저장할 변수 tmp
        int tmp = max;

        //stack을 돌며 max보다 큰 게 나오면 max를 교체 및 result 증가
        for(int i = 0; i < n; i++) {
            if(max < (tmp = stack.pop())) {
                max = tmp;
                result++;
            }
        }

        br.close();
        System.out.println(result);

        }
}
