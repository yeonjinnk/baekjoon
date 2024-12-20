import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, i);
        }
        
        int a, b, getA, getB;
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            getA = map.get(a);
            getB = map.get(b);
            map.put(a, getB);
            map.put(b, getA);
        }
        
        for(int i = 1; i <= n; i++) {
            System.out.print(map.get(i) + " ");
        }
        
    }
}