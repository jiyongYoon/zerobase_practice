package Practice;// 백준 9375번, 패션왕 신해빈

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Practice065 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        System.out.println();

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> cloth = new HashMap<>(); // 의상별로 몇개씩 있는지
            ArrayList<String> cate = new ArrayList<>(); // 카테고리 리스트
            for (int j = 0; j < n; j++) {
                String[] str = br.readLine().split(" ");
                if(cloth.containsKey(str[1])) {
                    cloth.put(str[1], (cloth.get(str[1]))+1);
                } else {
                    cloth.put(str[1], 1);
                }
                cate.add(str[1]); // 의상카테고리도 업데이트
            }

            int answer = 1;

            // 전체 경우의 수 구하기
            for (int j = 0; j < cloth.size(); j++) {
                answer *= (cloth.get(cate.get(j)))+1;
            }
            // 알몸인 경우 빼기
            System.out.println(answer - 1);
        }
    }
}
/*
[학습내용]
모든 경우의 수를 구하기가 어려우면
전체 경우에서 안되는 경우를 빼는 방법도 생각해보자
 */