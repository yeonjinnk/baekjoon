import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        //결과 문자열 저장할 sb
        StringBuilder sb = new StringBuilder();

        //버튼을 누른 횟수 N
        int n = Integer.parseInt(br.readLine());

        //앞뒤로 입출력 가능한 blockDeque
        Deque<String> blockDeque = new LinkedList<String>();
        //나중에 추가된 문자열 판별 위한 blockStack
        Stack<String> blockStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        Map<Integer, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            //입력값 각 줄의 앞 번호 switchNum
            int switchNum = Integer.parseInt(tokenizer.nextToken());

            //입력값 뒷 문자 block
            String block;

            //1, 2일 때는 앞/뒤로 blockDeque에 입력 및 blockStack에 순서대로 push
            //3일 때는 blockStack 마지막 문자를 blockDeque에서 제거 후 blockStack에서도 pop
            switch(switchNum) {
                case 1: blockDeque.addLast(block= tokenizer.nextToken()); blockStack.push(block);
                    indexStack.push(switchNum);
                    break;
                case 2: blockDeque.addFirst(block= tokenizer.nextToken()); blockStack.push(block);
                    indexStack.push(switchNum);
                    break;
                case 3:
                    if(!indexStack.isEmpty()) {
                        if(indexStack.peek() == 1) {
                            blockDeque.removeLast(); blockStack.pop(); indexStack.pop(); break;
                        } else if(indexStack.peek() == 2) {
                            blockDeque.removeFirst(); blockStack.pop(); indexStack.pop(); break;
                        } else {
                            continue;
                        }
                    }


            }

//            System.out.println(blockDeque.toString());
        }
//        System.out.println(blockDeque.toString());
        for(String block : blockDeque) {
            sb.append(block);
        }
        String result = sb.length() == 0 ? "0" : sb.toString();
        System.out.println(result);
//        br.close();



    }


}
