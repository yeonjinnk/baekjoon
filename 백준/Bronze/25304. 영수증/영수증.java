import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int count = sc.nextInt();
        int price;
        int num;
        for(int i = 0; i < count; i++) {
            price = sc.nextInt();
            num = sc.nextInt();
            total -= price * num;
        }
        
        System.out.println(total == 0 ? "Yes" : "No");
    }
}