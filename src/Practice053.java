// 연습문제
// m X n 이차원 배열에서 0이 있는 행과 열의 원소 모두를 0으로 만드는 프로그램 작성.
public class Practice053 {
    public static int[][] solution(int[][] arr) {
        int[][] answer = new int[arr.length][arr[0].length];
        String zeroColIdx = "";
        String zeroRowIdx = "";

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]==0) {
                    zeroColIdx += Integer.toString(i);
                    zeroRowIdx += Integer.toString(j);
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                if(zeroColIdx.contains(Integer.toString(i)) || zeroRowIdx.contains(Integer.toString(j))) {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        solution(arr);
        System.out.println();
        int[][] arr2 = {{1,1,0}, {1,1,1}, {0,1,1}};
        solution(arr2);
    }
}