import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String result = "";
        if(score >= 90 && score <= 100) {
            result = "A";
        } else if(score >= 80 && score <= 89) {
            result = "B";
        } else if(score >= 70 && score <= 79) {
            result = "C";
        } else if(score >= 60 && score <= 69) {
            result = "D";
        } else {
            result = "F";
        }
        System.out.println(result);
    }
}