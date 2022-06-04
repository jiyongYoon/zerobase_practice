//코딩테스트 연습문제
//배열의 주변평균 구하기
public class Practice048 {
    public static int[][] solution(int[][] image, int K) {
        int answer[][] = new int[image.length][image[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                System.out.print(image[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                answer[i][j] = avg(image, i, j, K);
            }
        }
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                System.out.print(answer[i][j]+"\t");
            }
            System.out.println();
        }
        return answer;
    }

    public static int avg(int[][] image, int i, int j, int K) {
        int sum = 0;

        for (int a = i-(K/2); a <= i + (K/2); a++) { // 더해야 할 인덱스 범위 설정
            for (int b = j-(K/2); b <= j + (K/2); b++) {
                if (a < 0 || b < 0 || a >= image.length || b >= image[0].length) { // 바운더리를 넘어가면 아무것도 안함

                } else { // 바운더리 내에 있으면 sum에 더하기
                    sum += image[a][b];
                }
            }
        }
        return sum / (K*K) ;
    }
    public static void main(String[] args) {
        solution(new int[][]{{4, 5, 2, 6, 7},{5, 4, 2, 4, 6},{6, 8, 4, 8, 7},{7, 3, 6, 6, 4},{5, 0, 4, 1, 5}},3);
    }
}
/*
[학습내용]
배열을 돌 때 바운더리를 넘지 않을때 처리하는 방법
- idx < 0, idx >= arr.length
 */