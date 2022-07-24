// 백준 1446번 지름길
// https://www.acmicpc.net/problem/1446

/*
1. 아이디어
DP로 풀어보자. 모든 지름길을 시작위치 기준으로 정렬하고, 이후에 for문을 돌면서 도착지점까지 DP배열 완성해가자.
DP배열 업데이트 값은 해당 도로가 끝나는 지점.

2. 시간복잡도
for문: 1 <= D <= 10,000

3. 자료구조
지름길 개수: 1 <= N <= 12
고속도로 길이: 1<= D <= 10,000
int 가능
 */
package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice120 {
    static PriorityQueue<ShortCut> pq;
    static class ShortCut {
        int start;
        int end;
        int weight;

        public ShortCut(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void solution(int n, int d) {

        int[] dp = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i <= d; i++) {
            if(!pq.isEmpty()) {
                ShortCut cur = pq.peek();

                if(cur.start == i) {
                    if(i != 0) {
                        dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
                    }
                    if(cur.end > d) {
                        pq.poll();
                    } else {
                        pq.poll();
                        dp[cur.end] = Math.min(dp[cur.start] + cur.weight, dp[cur.end]);
                    }

                    if(!pq.isEmpty()) {
                        ShortCut nextCur = pq.peek();
                        if (nextCur.start == cur.start) {
                            i--;
                            continue;
                        }
                    }
                } else {
                    if(i == 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
                }
            } else {
                if(i == 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            }
        }

        System.out.println(dp[d]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>((x, y) -> x.start - y.start);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(start > d || end > d || end - start <= weight) {
                continue;
            }
            pq.offer(new ShortCut(start, end, weight));
        }
        solution(n, d);
    }
}