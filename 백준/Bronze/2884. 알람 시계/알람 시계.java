import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int h = sc.nextInt();
        int m = sc.nextInt();
        
        if(m >= 45) {
            System.out.println(h + " " + (m - 45));
        } else if(h == 0) {
           System.out.println(23 + " " + (m + 60 - 45));    
        } else {
            System.out.println((h - 1) + " " + (m + 60 - 45));
        }
    }
}