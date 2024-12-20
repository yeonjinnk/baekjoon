import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int longCount = n / 4;
        
        for(int i = 0; i < longCount; i++) {
            System.out.printf("long ");
        }
        System.out.printf("int");
        
    }
}