// 백준 20922번 겹치는 건 싫어
// https://www.acmicpc.net/problem/20922

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Practice084 {
    public static void solution(int[] arr, int n, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        if(n == 1) {
            System.out.println("1");
            return;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        while(right != arr.length) {
            hm.put(arr[right], hm.getOrDefault(arr[right], 0) + 1);
            if(hm.get(arr[right]) > k) {
                if(arr[0] == arr[right]) {
                    hm.put(arr[left], hm.get(arr[left]) - 1);
                    left++;
                } else {
                    while (arr[left] != arr[right]) {
                        hm.put(arr[left], hm.get(arr[left]) - 1);
                        left++;
                    }
                    hm.put(arr[left], hm.get(arr[left]) - 1);
                    left++;
                }
            }
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        if(maxLength == 0) {
            System.out.println(arr.length);
            return;
        }
        System.out.println(maxLength);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        String[] s2 = br.readLine().split(" ");
        int[] arr = new int[s2.length];
        for (int i = 0; i < s2.length; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }
        solution(arr, n, k);
    }
}
