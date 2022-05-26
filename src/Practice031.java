//Q6. 카탈랑수 구하기

public class Practice031 {
    static int cata(int n) {
        int answer = 0;
        if(n==0 || n==1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            answer += cata(i) * cata(n-1-i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(cata(0));
        System.out.println(cata(1));
        System.out.println(cata(2));
        System.out.println(cata(3));
        System.out.println(cata(5));
        System.out.println(cata(7));

    }
}
