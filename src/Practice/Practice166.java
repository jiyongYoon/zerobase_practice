// 프로그래머스 Lv.1 문자열 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/140108

package Practice;

public class Practice166 {
    public static int solution(String s) {
        if(s.length() == 1) {
            return 1;
        }
        int answer = 0;

        char[] arr = s.toCharArray();
        int idx = 0;
        while(idx < arr.length - 1) {
            int[] cnt = new int[2];
            char firstChar = arr[idx];
            cnt[0]++;
            while(cnt[0] != cnt[1]) {
                idx++;
                char nextChar = arr[idx];
                if(firstChar == nextChar) {
                    cnt[0]++;
                } else {
                    cnt[1]++;
                }
                if(idx == arr.length - 1) {
                    break;
                }
            }
            answer++;
            idx++;
            if(idx == arr.length - 1) {
                answer++;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        String s = "abracadabra";
//        String s = "banana";
        String s = "ssssssss";
        System.out.println(solution(s));
    }
}
