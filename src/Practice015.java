import java.util.ArrayList;

public class Practice015 {
//    Q15. n개의 정수형 데이터 height배열.
//    각 원소는 벽의 높이를 의미
//    벽 사이사이의 빈 공간을 담을 수 있는 물의 총 량 출력하기.

//    1) 왼쪽부터 벽의 유무 체크
//    2) 있으면 고정하고 그 벽보다 오른쪽 벽 중에서 높으면 물 담을 수 있음
//    3) 물의 양은 그 벽까지 각 열의 높이 체크
//       고정된 벽에서 각 열의 벽의 높이를 뺀 수가 그 열의 물의 양

    public static void water(int[] height) {
        ArrayList<Integer> w = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < height.length; i++) { // 좌측벽 0~
            for (int j = i+1; j < height.length; j++) { // 우측벽 1~
                if (height[i] > 0) { // 좌측 index에 벽 있으면
                    if (height[j] >= height[i]) { // 오른쪽에 좌측벽보다 같거나 높을때까지
                        for (int k = i + 1; k < j; k++) {
                            w.add(height[i] - height[k]); // 물의 양 추가
                        }
                        i = j-1; // 좌측벽 시작점 이동
                        break;
                    }
                } else {
                    break; // 벽 높이가 없으면 좌측벽 Index 한칸 이동
                }
            }
        }
        // 넓이 리스트 합 출력
        for (int i = 0; i < w.size(); i++) {
            sum = sum + w.get(i);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        water(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        water(new int[]{4, 2, 0, 3, 2, 5});
        water(new int[]{3, 0, 3, 0, 3});
    }

}
