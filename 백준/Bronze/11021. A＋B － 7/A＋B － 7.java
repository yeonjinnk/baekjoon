import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a, b;
        for(int i = 1; i <= T; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.printf("Case #%d: %d\n", i, a + b);
        }
    }
}