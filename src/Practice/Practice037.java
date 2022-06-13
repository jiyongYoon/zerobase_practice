package Practice;// 배열을 오름차순으로 정렬하기
// 버블정렬 사용
import java.util.Arrays;
public class Practice037 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 6, 1};
        int lidx = 0;
        for (int i = arr.length-1; i >=0 ; i--) {
            int idx = arr.length-1;
            while(idx>lidx) {
                if (arr[idx] < arr[idx - 1]) {
                    int tmp = 0;
                    tmp = arr[idx - 1];
                    arr[idx - 1] = arr[idx];
                    arr[idx] = tmp;
                }
                idx--;
            }
            lidx++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
