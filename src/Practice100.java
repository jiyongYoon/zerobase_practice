// 프로그래머스 Lv.2 점프와 순간이동
// https://school.programmers.co.kr/learn/courses/30/lessons/12980
public class Practice100 {
    public int solution(int n) {
        int ans = 0;

        while(n > 0) {
            if(n % 2 == 0) {
                n = n / 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}

/*
[학습내용]
그리디 알고리즘, 0에서 출발하는 것이 아니라 목표지점에서 빼나가는 것으로 접근함
 */
