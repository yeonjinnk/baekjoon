import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력 br, 입력값 구분할 tokenizer, 결과 문자열 저장할 sb
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> BracketStack;
        String s;
        StringBuilder result = new StringBuilder();
        while(true) {
            s = br.readLine();
            BracketStack = new Stack<>();
            if(!s.equals(".")) {
                for(char c : s.toCharArray()) {
                    if(c == '(') {
                        BracketStack.push(c);
                    } else if(c == ')') {
                        if(!BracketStack.isEmpty() && BracketStack.peek() == '(') {
                            BracketStack.pop();
                        } else {
                            BracketStack.push(c);
                        }
                    } else if(c == '[') {
                        BracketStack.push(c);
                    } else if(c == ']') {
                        if(!BracketStack.isEmpty() && BracketStack.peek() == '[') {
                            BracketStack.pop();
                        } else {
                            BracketStack.push(c);
                        }
                    }
                }
                if(BracketStack.isEmpty()) {
                    result.append("yes" + "\n");
                } else {
                    result.append("no" + "\n");
                }
            } else {
                break;
            }
        }
        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();

    }
}

