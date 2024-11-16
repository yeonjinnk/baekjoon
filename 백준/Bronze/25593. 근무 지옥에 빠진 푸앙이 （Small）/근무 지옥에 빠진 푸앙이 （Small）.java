import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//입력 br, 출력 bw, 공백 분리 st, 문자열 조합 sb
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//근무자 저장할 컬렉션 Set
		Set<String> set = new HashSet<String>();
		
		//각 줄의 근무시간 저장할 컬렉션 map
		Map<Integer, Integer> hourMap = new HashMap<Integer, Integer>();
		hourMap.put(1, 4); // 08:00~12:00(4h)
		hourMap.put(2, 6); // 12:00~18:00
		hourMap.put(3, 4); // 18:00~22:00
		hourMap.put(4, 10); // 22:00~08:00
		
		//사람 이름과 근무시간 저장할 컬렉션 map
		Map<String, Integer> nameHourMap = new HashMap();
		
		//주의 개수 weekSize
		int weekSize = Integer.parseInt(br.readLine());
		
		//weekSize만큼 4교대 -> 이중 for문 사용
		for(int i = 1; i <= weekSize; i++) { //변수 i는 주의 개수 weekSize
			for(int j = 1; j <= 4; j++) { //변수 j는 해당 주의 시간대를 나타냄
				st = new StringTokenizer(br.readLine(), " ");
				//token 존재할 때까지 반복
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					
					//이름이 처음 나올 때
					if(!set.contains(token)) {
						set.add(token); //근무자 저장하는 set에 이름 저장
						nameHourMap.put(token, hourMap.get(j)); //해당 시간대(hourMap)을 더하기
					} else { //이름 존재할 때
						//기존 시간 + 해당 시간대(hourMap)을 더하기
						nameHourMap.put(token, nameHourMap.get(token) + hourMap.get(j));
					}
				}
			} //4교대 for문 끝
		} //weekSize for문 끝
		
		//-는 근무한 사람이 x, -는 근무자가 아니므로 제거
		nameHourMap.remove("-");
		
		//최대 - 최소값이 12 이하여야 공평하므로
		//map에 저장된 values 중 최대, 최소값을 구하기
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int n : nameHourMap.values()) {
			if(n > max) {
				max = n;
			}
			if(min > n) {
				min = n;
			}
		}
		
		
		br.close(); //입력 스트림 닫
		bw.write(max - min > 12 ? "No" : "Yes"); //출력문 저장
		bw.flush(); //출력
		bw.close(); //출력 스트림 닫
	}
}
