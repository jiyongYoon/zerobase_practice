package Practice;// 프로그래머스 Lv.1
// 문자열 내 마음대로 정렬하기
// strings 문자 배열의 n번 인덱스로 정렬하여 출력하기

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public class Practice067 {
    public static ArrayList<String> solution(String[] strings, int n) {
        ArrayList<String> answer = new ArrayList<>();
        // 트리맵으로 자료 담기. 키는 인덱싱한 문자, 값은 원래 문자열(리스트)
        TreeMap<String, ArrayList<String>> tm = new TreeMap<>();

        for (int i = 0; i < strings.length; i++) {
            // 인덱싱 키 값 뽑아내기
            String key = strings[i].substring(n, n+1);
            // 리스트 만들어서
            ArrayList<String> arr = tm.getOrDefault(key, new ArrayList<>());
            arr.add(strings[i]); // 리스트에 원래 문자열 추가
            arr.sort(Comparator.naturalOrder()); // 리스트 정렬
            tm.put(key, arr); // 트리맵에 추가
        }

        // 트리맵에 있는 값들 모두 정답리스트에 담기
        for (String key : tm.keySet()) {
            int idx = 0;
            for(int i = 0; i < tm.get(key).size(); i++) {
                answer.add((tm.get(key)).get(idx++));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        solution(strings, n);
    }
}

/*
[학습내용]
1) getOrDefault: 맵의 키에 해당하는 값이 없을 경우 null 대신 매개변수 값을 리턴.
map.getOrDefault(키, 값);
2) 맵의 값 출력
참고자료: https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=simpolor&logNo=221216146941
 */