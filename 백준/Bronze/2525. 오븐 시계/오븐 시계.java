import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int time = sc.nextInt();
        m += time;
        int plusH = m / 60;
        int newMin = m % 60;
        int newH = (h + plusH) > 23 ? (h + plusH - 24) : (h + plusH);
        System.out.println(newH + " " + newMin);
        
    }
}