import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int aSize = Integer.parseInt(str.nextToken());
		int bSize = Integer.parseInt(str.nextToken());
		
		Set<Integer> setA = new HashSet<Integer>();
		Set<Integer> setB = new HashSet<Integer>();
		
		str = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < aSize; i++) {
			setA.add(Integer.parseInt(str.nextToken()));
		}
		
		str = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < bSize; i++) {
			setB.add(Integer.parseInt(str.nextToken()));
		}
		
		int uniqueInA = 0;
		for(int num : setA) {
			if(!setB.contains(num)) {
				uniqueInA++;
			}
		}
		int uniqueInB = 0;
		for(int num : setB) {
			if(!setA.contains(num)) {
				uniqueInB++;
			}
		}
		
		System.out.println(uniqueInA + uniqueInB);
		
	    }
}
