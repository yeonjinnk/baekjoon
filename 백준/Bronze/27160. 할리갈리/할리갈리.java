import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//입력 br, 출력 bw, 공백 분리 st
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//펼쳐진 카드 개수
		int N = Integer.parseInt(br.readLine());
		
		//카드 종류 저장할 컬렉션 set
		Set<String> set = new HashSet<String>();
		
		//카드 종류와 펼쳐진 수 저장할 컬렉션 map
		//key : 카드종류, value : 해당 종류의 펼처진 카드 수
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//cardNum만큼 map에 펼쳐진 카드와 해당 수를 더해나가기!!
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String cardType = st.nextToken();
			int cardNum = Integer.parseInt(st.nextToken());
			
			if(!set.contains(cardType)) {
				set.add(cardType);
				map.put(cardType, cardNum);
			} else {
				map.put(cardType, map.get(cardType) + cardNum);
			}
		}
		
		br.close(); //입력 스트림 닫
		bw.write(map.containsValue(5) ? "YES" : "NO"); //출력문 저장
		bw.flush(); //출력
		bw.close(); //출력 스트림 닫
	}
}
