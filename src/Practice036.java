public class Practice036 {
    // ㄷ자 반시계방향으로 숫자채우기 (재귀)
        static int solution(int n, int i, int j) {
            return dig(0,n,i,j);
        }
        static int dig(int count, int n, int i, int j) {
            if(n==2) { // 마지막 2 by 2면 탈출
                if(i==0&&j==1) { // 1사분면이면 +1
                    return count + 1;
                } else if (i==0&&j==0) { // 2사분면이면 +2
                    return count + 2;
                } else if (i==1&&j==0) { // 3사분면이면 +3
                    return count + 3;
                } else { // 4사분면이면 +4
                    return count + 4;
                }
            }

            int m = n / 2; //스택이 올라갈수록 i, j의 위치가 달라짐. 나머지 사분면은 숫자를 배열하지 않고 다 채우는걸로 해서 카운트만 함
            if(i<m&&j>=m) {
                return dig(count, m, i, j-m);
            } else if(i<m&&j<m) {
                count += m*m;
                return dig(count, m, i, j);
            } else if(i<m&&j>=m) {
                count += m*m*2;
                return dig(count, m, i-m, j);
            } else {
                count += m*m*3;
                return dig(count, m, i-m, j-m);
            }
        }

    public static void main(String[] args) {
        System.out.println(solution(4,1,2));
    }
}
/*
[학습내용]
전체 규칙을 본 후, 없애도 될 계산들을 확인하기.
 */


