import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = fibo(n);

        System.out.println(result);
    }

    static int fibo(int n) {
        //기저조건
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            //Recursion 조건
            return fibo(n-1) + fibo(n-2);
        }
    }
}