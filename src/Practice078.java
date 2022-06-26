// 프로그래머스 Lv.2
// Summer/Winter Coding(2019) / 멀쩡한 사각형

public class Practice078 {
    public static long solution(int w, int h) {
        long answer = 1;
        long a, b = 0;
        if(w == h) {
            return (long)w * (long)h - w;
        } else {
            a = Math.max(w, h);
            b = Math.min(w, h);
        }

//        double cnt =((double)a / (double)b);
        long blank = 0;

        // 최대공약수
        long gcdInt = gcd(a, b);

        // 가로를 최대공약수로 나눈곳 까지 빈칸 몇번인지
        for (int i = 0; i < (b / gcdInt); i++) {
            blank += (Math.ceil((i + 1) * (double)a / (double)b) - Math.floor(i * (double)a / (double)b));
        }
        // 전체에서 빈칸 빼기
        // 빈칸은 최대 공약수만큼 blank 패턴이 반복됨.
        // 전체에서 그만큼을 빼주면 됨.
        answer = (a * b) - (gcdInt * blank);
        return answer;
    }

    // 유클리드 호제법
    public static long gcd(long a, long b) {
        if(a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w, h));

    }
}

/*
[학습내용]
커뮤니티에도 매우 화난 사람들이 있음.
코드는 정답인데 부동소수점 계산오류로 인해 통과가 안되는 것들이 있음.
이럴때는 곱하기 먼저하고 마지막에 나누기 연산을 해주면 됨.
 */
