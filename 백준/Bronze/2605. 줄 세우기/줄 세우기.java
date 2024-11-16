import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//입력 br, 출력 bw, 공백 읽어올 st, 결과값 저장할 sb
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		//학생 줄을 선 순서를 나타낼 list 컬렉션
		List<Integer> list = new ArrayList<Integer>();
		
		//첫째 줄 학생 수
		int personSize = Integer.parseInt(br.readLine());
		//둘 째 줄 뽑은 번호 읽어오기
		st = new StringTokenizer(br.readLine(), " ");
		
		br.close(); //입력 스트림 닫음
		
		//1 ~ 학생수(personSize)만큼 list에 추가
		for(int i = 1; i <= personSize; i++) {
			list.add(i);
		}
		
		//list의 각 인덱스를 돌면서 자리 바꾸기를 진행함
		for(int i = 0; i < list.size(); i++) {
			
			//뽑은 번호 selectedNum에 저장
			//token 읽어오는 것도 학생 수(list에 저장된 수) 만큼 반복되므로
			//반복문 내에서 수행
			int selectedNum = Integer.parseInt(st.nextToken());
			
			//selectedNum이 0인 경우, 자리이동 없으므로 반복문 pass
			if(selectedNum == 0) {
				continue;
			} else { 
				
				//그 외, 뽑은 번호만큼 앞자리와 swap
				//Collections클래스의 내장메서드 사용
				//현재 index인 i에서 시작, selectedNum번 해야하니까 (i-selNum)까지 
				//인덱스 전진해가며 반복하므로 감소연산자
				for(int j = i; j > i-selectedNum; j--) { 
					Collections.swap(list, j, j-1);
				}//swap for문 종료
			}
		} //list for 종료
		
		//최종 바뀐 list를 공백 띄우고 출력 형태로 저장
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			sb.append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	    }
}
