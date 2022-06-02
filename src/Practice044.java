// 프로그래머스 Lv.1 약수의 개수와 덧셈
public class Practice044 {
    public static int divCount(int n) {
        int count = 0;
        for (int a = 1; a <= (n/a); a++) { // 12의 약수를 구한다고 가정하면, 12 = 1 * 12 / 12 = 2 * 6 / 12 = 3 * 4 해서 쌍이 나오는 걸로 해결 // 자기자신을 /1, /2, /3,,, 하면서 나누어떨어지는게 있는지 -> 큰 수부터 약수를 확인해가는 방법
            if((n%a)==0) { // 나머지가 0이면 약수 쌍 중 큰 수
                if(a==(n/a)) { // 25를 5로 나눴을때는 5X5처럼 같을때
                    count++; // 1개만 추가
                } else { // pair가 있을때는
                    count=count+2; // 2개 추가
                }
            }
        }
        return count;
    }

    public static int solution(int left, int right) {
        int answer  = 0;
        for (int i = left; i <= right; i++) {
            if(divCount(i)%2==0) { // 약수 개수가 짝수면 더하고, 홀수면 빼고
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));

    }
}

/*
[다른풀이 1]
관점은 똑같은데, 실제 약수의 개수를 구할 필요 없이 짝수인지 홀수인지만 판별함. 굿....
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i<=right; ++i){
            int count = 0;
            for(int j=1; j<=i; ++j)
                if(i%j == 0) // 나누어떨어지면 약수임
                    count++;

            if(count%2 == 0) // 그 나누어떨어지는 수의 쌍이 짝수개면
                answer += i; // 약수개수는 짝수개 (14는 count 4가 나옴)
            else
                answer -= i; // 아니면 홀수개 (25는 coun 3이 나옴)
        }
        return answer;
    }
}

[다른풀이2]
25일때 5*5=25 이럴때만 홀수개라는 것을 착안. 대박이다....
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }
}
 */