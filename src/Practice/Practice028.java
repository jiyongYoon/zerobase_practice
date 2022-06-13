package Practice;

import java.util.Arrays;
// 재도전 필요
// Q3. 문자열 s1, s2이 있을 때, s1을 permutation 한 값중 하나가 s2에 포함되어 있으면 true,
//     없으면 false를 반환하는 프로그램 작성.
public class Practice028 {
    static void permu(String s1, String s2, int depth, int n, int r, boolean[] check, String out, int outIdx) {
        if(outIdx == r) {
            System.out.println(out);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(check[i] == false) {
                out += s1.substring(i, i+1);
                check[i] = true;
                permu(s1, s2, depth+1, n, r, check, out, outIdx+1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ab";
        boolean[] check = new boolean[s1.length()];
        permu(s1, s2, 0, 3, 3, check, "", 0);
    }
}