package Practice;// 프로그래머스 Lv.1
// 같은 숫자는 싫어

import java.util.Arrays;

public class Practice063 {
    public static int[] solution(int []arr) {
        StringBuffer sb = new StringBuffer();
        sb.append(Integer.valueOf(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1]!=arr[i]) {
                sb.append(Integer.valueOf(arr[i]));
            }
        }

        int[] answer = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            answer[i] = Integer.parseInt(sb.substring(i,i+1));
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
