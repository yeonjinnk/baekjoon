import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.SelectableChannel;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        double sum  = 0;

        for(int i = 0 ; i < n ; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        Arrays.sort(nums);

        int count = 0;
        int max = -1;
        int mod = nums[0];

        boolean check = false;

        for(int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                count++;
            }else {
                count = 0;
            }

            if(max < count) {
                max = count;
                mod = nums[i];
                check = true;
            }else if(max == count && check == true) {
                mod = nums[i];
                check = false;
            }
        }
        System.out.println(Math.round(sum / n));
        System.out.println(nums[(n - 1) / 2]);
        System.out.println(mod);
        System.out.println(nums[n - 1] - nums[0]);
}

}