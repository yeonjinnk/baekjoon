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

        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력값 저장할 배열 arr
        int[] arr = new int[n];

        //입력값 중복값 제거(정렬 후 index 공란 방지)
        Set<Integer> set = new HashSet<>();

        //입력값 arr과 set에 저장
        for (int i = 0; i < n; i++) {
            int elem = Integer.parseInt(st.nextToken());
            arr[i] = elem;
            set.add(elem);
        }

        //set에 저장된 원소를 list에 저장
        List<Integer> list = new ArrayList<>();
        for(int elem : set){
            list.add(elem);
        }

        //list 오름차순 정렬
        Collections.sort(list);

        //입력값 key, 입력값보다 작은 숫자 수 value
        //list 자료구조에 오름차순 정렬 되어잇으므로 list의 index는 해당 숫자보다 적은 숫자 수
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i), i));
        }

        //결과값 출력
        for(int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
