import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //[문제분석]
        //1. 한번 입은 조합 다시 안 입음
        //2. 조합 한 번 돌리는 횟수 구하기
        //3. 같은 의상 종류는 히니만 가능

        //[문제접근]
        //의상 타입별 숫자를 가지고 조합을 하므로
        //map에 타입과 타입의 개수를 저장
        //각 타입이 없을 때 추가해야 하므로 해당 타입의 value + 1로 곱해나가고
        //각 타입이 모두 없을 경우 1가지를 차감해서 구함.

        //[입력]
        //테스트 케이스 수 caseCount
        //  첫 줄 : 의상 수 clothingCount (1 ~ 100)
        //  두번재 줄 : 가진 의상 수 clothingCount (0 ~ 30)
        //  세번째 줄 : 의상 이름 clothingName 의상 종류 clothingType

        //[출력]
        //테스트케이스별 조합 구하기

        //1. 입력값을 테스트 케이스 수 caseCount 변수 선언 및 저장
        //2. 입력값을 의상 수 clothingCount 변수 선언 및 저장
        //3. map 구조에 key로 type과 value로 type의 개수를 저장
        //4. 반복문(clothingCount만큼)
        //  token으로 각 줄을 읽어와 각각 clothingName, clothingType 변수에 저장
        //  key가 존재할 경우) 기존 수에 +1, 없을 경우) value에 1 추가
        // 조합의 수를 곱해가야 하므로 combinationCount 변수 선언 후 1로 저장
        // 각 타입의 value + 1한 값을 곱하고, 최종적으로 1을 빼준다
        //최종 combinationCount 출력


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < caseCount; i++) {
            int clothingCount = Integer.parseInt(br.readLine());
            Map<String, Integer> clothingMap = new HashMap<>();
            for(int j = 0; j < clothingCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String clothingName = st.nextToken();
                String clothingType = st.nextToken();

                if(clothingMap.containsKey(clothingType)) {
                    clothingMap.put(clothingType, clothingMap.get(clothingType) + 1);
                } else {
                    clothingMap.put(clothingType, 1);
                }
            }
            int combinationCount = 1;
            for(String type : clothingMap.keySet()) {
                combinationCount *= (clothingMap.get(type) + 1);
            }
            combinationCount -= 1;

            bw.write(combinationCount + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
