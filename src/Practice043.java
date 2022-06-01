// 프로그래머스 Lv.1 소수찾기
// 에라토스테네스의 체 활용함.

public class Practice043 {
    public static int solution(int n) {
        int answer = 0;

        if(n<2) {
            answer = 0;
        } else {
            boolean[] pNum = new boolean[n+1]; // 소수면 false, 소수가 아니면 true
            pNum[0] = true;
            pNum[1] = true;
            for (int i = 2; i < Math.sqrt(n); i++) { // 해당 값의 루트값까지만 돌리면 됨. 8의 약수는 1, 2, 4, 8인데, 2*4=8, 4*2=8 동일하다보니
                if(pNum[i]==false) { // false면
                    for (int j = 2; i*j <= n; j++) { // 그 수를 두고 그 다음 배수부터 true로
                        pNum[i*j]=true;
                    }
                }
            }
            for (int i = 0; i < n+1; i++) {
                if (pNum[i] == false) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(5));
        System.out.println(solution(99));
        System.out.println(solution(1000000));

    }
}
