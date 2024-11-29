
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //음을 아는 노래 개수 n, 시도 노래 개수 m
        //다음줄 ~ n+1줄 노래 제목 길이 t, 노래 제목 s 일곱개 음이름 an
        //n+2줄~m줄 시도할 노래 음이름 b1b2b3
        //동일 하나 -> 노래제목
        //동일 2이상 -> ?
        //동일 x -> !

        //세 음을 key로 value를 제목으로
        //containkey 메서드로 확인해서 앞 세 음이 같다면 value에 duplicated를 저장
        
        //판별 시 각 key가 포함되어있지 않으면 ! duplicated면 ? 포함되면 제목 출력
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        //음을 아는 노래 개수 n, 시도할 노래 개수 m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int length = Integer.parseInt(st.nextToken());

            String title = st.nextToken();
            String musicNote = "";
//            System.out.println(length);
//            System.out.println(title);

            for(int j = 0; j < 3; j++) {
                musicNote += st.nextToken() + " ";
            }

            if(map.containsKey(musicNote)) {
                map.put(musicNote, "duplicated");
            } else {
                map.put(musicNote, title);
            }
//            System.out.println(map);
        }
//        System.out.println(map);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String quiz = "";
            while (st.hasMoreTokens()) {
                quiz += st.nextToken() + " ";
            }
//            System.out.println("quiz=" + quiz);

            String result = "";

            if(!map.containsKey(quiz)) {
                result = "!";
            } else if(map.get(quiz).equals("duplicated")) {
                result = "?";
            } else {
                result = map.get(quiz);
            }
//            System.out.println("result=" + result);

            bw.write(result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
