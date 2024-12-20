import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        
        int result = 0;
        
        if(n1 != n2 && n2 != n3 && n1 != n3) {
           result = Math.max(n1, Math.max(n2, n3)) * 100;
        } else if(n1 == n2 && n2 == n3 && n1 == n3) {
            result = 10000 + n1 * 1000;
        } else {
            int same = (n1 == n2) ? n1 : (n1 == n3) ? n1 : n2;
            result = 1000 + same * 100;
        }
        
        System.out.println(result);
       
    }
}