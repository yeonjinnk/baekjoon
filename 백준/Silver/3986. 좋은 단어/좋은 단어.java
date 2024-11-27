import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력 br, 입력값 구분할 tokenizer, 결과 문자열 저장할 sb
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack;
        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i = 0; i < n; i++) {
            stack = new Stack<>();
            for(char c: br.readLine().toCharArray()) {
                if(stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if(stack.peek().equals(c)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
//                System.out.println(stack);
            }
            if(stack.isEmpty()) result++;
        }
        System.out.println(result);
    }

}

