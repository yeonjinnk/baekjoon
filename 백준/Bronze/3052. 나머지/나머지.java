import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[42];
        int index = 0;
        int result = 0;
        for(int i = 0; i < 10; i++) {
            index = sc.nextInt() % 42;
            arr[index]++;
        }
        
        for(int i = 0; i < 42; i++) {
            if(arr[i] > 0) result++;
        }
        
        System.out.println(result);
        
        
    }
}