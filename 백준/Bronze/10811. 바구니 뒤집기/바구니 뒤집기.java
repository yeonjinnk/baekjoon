import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        
        int left, right, tmp;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());
            
            while(left < right) {
                tmp = arr[left - 1];
                arr[left - 1] = arr[right - 1];
                arr[right - 1] = tmp;
                left++;
                right--;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}