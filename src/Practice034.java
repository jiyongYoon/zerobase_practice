//Q9. 조건에 맞는 수의 개수 구하기

public class Practice034 {
    public static void main(String[] args) {
        int n = 10;
        int[] pNum = {2, 3, 5, 7};
        int[] eNum = {2, 4, 6, 8, 0};
        int result = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result *= eNum.length;
            } else {
                result *= pNum.length;
            }
        }
        System.out.println(result);
    }
}

