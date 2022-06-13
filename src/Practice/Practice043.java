package Practice;// 프로그래머스 Lv.1 소수찾기
// 에라토스테네스의 체 활용함.
// [제곱근까지만 루프 도는 이유]
// 만약 16까지 구한다고 한다면 루트16는 4
// 에라토스테네스의 체로 지우면
// 2*2, 2*3, 2*4, 2*5, 2*6, 2*7, 2*8
//      3*3,      3*5
// 4*2, 4*3 <- 지울라고 보니까 앞에서 이미 다 했던거

public class Practice043 {
    public static int solution(int n) {
        int answer = 0;

        if(n<2) {
            answer = 0;
        } else {
            boolean[] pNum = new boolean[n+1]; // 소수면 false, 소수가 아니면 true
            pNum[0] = true;
            pNum[1] = true;
            for (int i = 2; i < Math.sqrt(n); i++) { // 해당 값의 루트값까지만 돌리면 됨.
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
