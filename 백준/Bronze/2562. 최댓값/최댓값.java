import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < 9; i++) {
            if(max < arr[i]) {
                max = arr[i];
                maxIndex = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
        
    }
}