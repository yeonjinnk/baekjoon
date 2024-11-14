import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //입력값 n

        int[] arr = new int[46]; //피보나치 수를 갖는 배열 arr
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i < arr.length; i++) { //2번째 이후 피보나치 수는 앞 두 피보나치 수의 합
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);

        sc.close();
        }

}