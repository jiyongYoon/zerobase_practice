// 백준 1874 스택 수열
// https://www.acmicpc.net/problem/1874

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Practice134 {
    public static int[] arr;
    public static void solution(int k) {
        StringBuffer answer = new StringBuffer();

        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int i = 1; i <= arr.length; i++) {
            stack.push(i);
            answer.append("+\n");
            while(!stack.isEmpty() && stack.peek() == arr[idx]) {
                idx++;
                stack.pop();
                answer.append("-\n");
            }
        }
        if(idx != arr.length) {
            System.out.print("NO");
            return;
        }
        System.out.println(answer);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
        }
        solution(k);
    }
}
