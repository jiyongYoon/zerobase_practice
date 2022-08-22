// 프로그래머스 Lv.1 비밀지도
// https://school.programmers.co.kr/learn/courses/30/lessons/17681

package Practice;

public class Practice128 {

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String s1 = toWall(arr1[i], n);
            String s2 = toWall(arr2[i], n);
            String result = realWall(s1, s2);
            answer[i] = result;
        }

        return answer;
    }

    public static String toWall(int a, int n) {
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int tmp = a % 2;
            if(tmp == 1) {
                s.append("#");
            } else {
                s.append(" ");
            }
            a = a / 2;
        }

        StringBuffer returnString = new StringBuffer();
        for (int i = n - 1; i >= 0; i--) {
            returnString.append(s.charAt(i));
        }

        return returnString.toString();
    }

    public static String realWall(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                sb.append("#");
                continue;
            }

            if(s1.charAt(i) == ' ') {
                sb.append(" ");
            } else {
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        solution(n, arr1, arr2);
    }
}
