/*
백준 2259번 수열
https://www.acmicpc.net/problem/2559
1. 새로운 아이디어
처음에 0번 인덱스부터 K개의 값을 더하자.
그리고 for문으로 인덱스를 하나씩 뒤로 밀어가며 추가된 값은 더하고 빠지는 값은 빼자.
그리고 그 때마다 최대값을 갱신하자.

2. 시간복잡도
- N의 개수의 범위: 2 ~ 100,000
- N의 숫자의 범위: -100 ~ 100
- K의 숫자의 범위: 1 ~ N
1) for문: O(N)
2) 인덱스 밀어가며 추가, 제거 작업: 각 작업당 X2
3) 전체 시간복잡도: O(2N) == O(N)
=> 가능하겠구나

3. 자료구조
- N의 개수의 범위: 2 ~ 100,000
- N의 숫자의 범위: -100 ~ 100
- K의 숫자의 범위: 1 ~ N
1) 전체 수 배열: int배열 가능
=> -100 ~ 100을 커버하면 된다
2) K개를 더했을때 최대 값: int 가능
=> 최대 수인 100을 최대 개수인 100,000개만큼 더한다면
e^2 * e^5 = e^7 < 20억
=> int 가능
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice087 {
    static int n, k;
    static int[] arr;
    public static void solution() {
        int left = 0;
        int right = k - 1;
        int maxTemp = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxTemp = Math.max(maxTemp, sum);

        while(right < arr.length - 1) {
            sum += arr[++right];
            sum -= arr[left++];
            maxTemp = Math.max(maxTemp, sum);
        }
        System.out.println(maxTemp);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        arr = new int[n];
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }
        solution();
    }
}
