package Practice;// 백준 1940
// https://www.acmicpc.net/problem/1940

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice083 {
    public static void solution(int[] arr, int n, int m){
        Arrays.sort(arr);
        int answer = 0;
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == m) {
                answer++;
                left++;
                right--;
            } else if(sum > m) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        solution(arr, n, m);
    }

}
