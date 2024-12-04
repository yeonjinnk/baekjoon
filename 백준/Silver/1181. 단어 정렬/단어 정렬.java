import java.util.*;
import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.DoubleStream;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        //정렬 sort를 override
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            //compare 반환값이 양수일 때만 위치를 바꾼다.
           public int compare(String o1, String o2) {
               //길이 같으면 사전순
               if(o1.length() == o2.length()) {
                   return o1.compareTo(o2); //사전순 정렬
               } else { //길이 비교해서 자리바꿈
                    return o1.length() - o2.length();
               }
           }
        });

        //중복값 제거 위해 list 자료구조 선언 및 초기화
        List<String> list = new ArrayList<>();
        for(String elem : arr) {
            if(!list.contains(elem)) {
                list.add(elem);
                sb.append(elem + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();







    }

}
