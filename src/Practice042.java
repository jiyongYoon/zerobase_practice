// 프로그래머스 Lv.1 <정렬>
// 버블정렬을 사용하여 배열 정렬함
import java.util.Arrays;

public class Practice042 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int k = 0; k < commands.length; k++) {

            int[] array1 = new int[commands[k][1] - commands[k][0] + 1];
            for (int i = 0; i < array1.length; i++) {
                array1[i] = array[commands[k][0] - 1 + i];
            }

            for (int i = 0; i < array1.length; i++) {
                int lastIdx = array1.length - 1;
                for (int j = 0; j < array1.length - 1 - i; j++) {
                    if (array1[lastIdx] < array1[lastIdx - 1]) {
                        int tmp;
                        tmp = array1[lastIdx - 1];
                        array1[lastIdx - 1] = array1[lastIdx];
                        array1[lastIdx] = tmp;
                    }
                    lastIdx--;
                }
            }
            answer[k] = array1[commands[k][2] - 1];
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1,5,2,6,3,7,4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}});
    }
}
