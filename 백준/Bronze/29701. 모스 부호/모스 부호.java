import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//입력 br, 출력 bw, 공백 분리 st, 문자열 조합 sb
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//모스부호 길이 morseSize
		int morseSize = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		//모스부호 해독 map
		//key:모스부호 value:해독문자
		Map<String, String> map = new HashMap<String, String>();
		map.put(".-", "A");	map.put("-...", "B");map.put("-.-.", "C");map.put("-..", "D");
		map.put(".", "E");map.put("..-.", "F");map.put("--.", "G");map.put("....", "H");
		map.put("..", "I");map.put(".---", "J");map.put("-.-", "K");map.put(".-..", "L");
		map.put("--", "M");map.put("-.", "N");map.put("---", "O");map.put(".--.", "P");
		map.put("--.-", "Q");map.put(".-.", "R");map.put("...", "S");map.put("-", "T");
		map.put("..-", "U");map.put("...-", "V");map.put(".--", "W");map.put("-..-", "X");
		map.put("-.--", "Y");map.put("--..", "Z");map.put(".----", "1");map.put("..---", "2");
		map.put("...--", "3");map.put("....-", "4");map.put(".....", "5");map.put("-....", "6");
		map.put("--...", "7");map.put("---..", "8");map.put("----.", "9");map.put("-----", "0");
		map.put("--..--", ",");map.put(".-.-.-", ".");map.put("..--..", "?");map.put("---...", ":");
		map.put("-....-", "-");map.put(".--.-.", "@");

		//token 존재할 때까지 map에서 token을 키로 값을 불러와 sb에 추가
		while(st.hasMoreTokens()) {
			sb.append(map.get(st.nextToken()));
		}
		
		br.close(); //입력 스트림 닫
		bw.write(sb.toString()); //출력문 저장
		bw.flush(); //출력
		bw.close(); //출력 스트림 닫
	}
}
