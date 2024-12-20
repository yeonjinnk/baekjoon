import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a, b, c;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            for(int j = a; j <= b; j++) {
                map.put(j, c);
            }
        }
        for(int i = 1; i <= n; i++) {
            System.out.print(map.getOrDefault(i, 0) + " ");
        }
    }
}