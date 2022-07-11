package Practice;// 백준 1484 다이어트
// https://www.acmicpc.net/problem/1484

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Practice086 {
    public static void solution(Long n) {
        if(n == 1) {
            System.out.println(-1);
            return;
        }
        long left = 1;
        long right = n;
        ArrayList<Long> arr = new ArrayList<>();
        while(left < right) {
            right = n;
            if(n % left == 0) {
                right = n / left;
                if((right + left) % 2 == 0 && left != right) {
                    if(!(arr.contains((right + left) / 2))) {
                        arr.add((right + left) / 2);
                    }
                }
            }
            left++;
        }
        if(arr.isEmpty()) {
            System.out.println(-1);
            return;
        }
        arr.sort(Comparator.naturalOrder());
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        solution(n);
    }
}
