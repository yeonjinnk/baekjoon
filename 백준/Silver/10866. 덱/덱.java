
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력 br, 입력값 구분할 tokenizer, 결과 문자열 저장할 sb
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            String command = tokenizer.nextToken();
            if(tokenizer.hasMoreTokens()) {
                int param = Integer.parseInt(tokenizer.nextToken());
                if(command.equals("push_front")) {
                    push_front(deque, param);
                } else if(command.equals("push_back")) {
                    push_back(deque, param);
                }
            }
            if(command.equals("pop_front")) {
                sb.append(pop_front(deque)).append("\n");
            } else if(command.equals("pop_back")) {
                sb.append(pop_back(deque)).append("\n");
            } else if(command.equals("size")) {
                sb.append(size(deque)).append("\n");
            } else if(command.equals("empty")) {
                sb.append(empty(deque)).append("\n");
            } else if(command.equals("front")) {
                sb.append(front(deque)).append("\n");
            } else if(command.equals("back")) {
                sb.append(back(deque)).append("\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void push_front(Deque<Integer> deque, int n) {
        deque.addFirst(n);
    }
    public static void push_back(Deque<Integer> deque, int n) {
        deque.addLast(n);
    }
    public static int pop_front(Deque<Integer> deque) {
        if(!deque.isEmpty()) {
            return deque.removeFirst();
        } else {
            return -1;
        }
    }
    public static int pop_back(Deque<Integer> deque) {
        if(!deque.isEmpty()) {
            return deque.removeLast();
        } else {
            return -1;
        }
    }
    public static int size(Deque<Integer> deque) {
        return deque.size();
    }
    public static int empty(Deque<Integer> deque) {
        if(deque.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
    public static int front(Deque<Integer> deque) {
        if(deque.isEmpty()) {
            return -1;
        } else {
            return deque.peekFirst();
        }
    }
    public static int back(Deque<Integer> deque) {
        if(deque.isEmpty()) {
            return -1;
        } else {
            return deque.peekLast();
        }
    }
}

