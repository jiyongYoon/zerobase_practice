public class Practice005 {
//    Q5. height 배열이 주어질 때, 원소의 갯수는 x축, 원소의 각각의 값은 y축을 나타낸다.
//        이 중 어떤 두 벽을 고르면 가장 많은 물을 담을 수 있는지를 확인하여 그 값을 출력하라.
//        입출력 예시)
//        1,8,6,2,5,4,8,3,7 => 49 // 5,3,9,2,1,1,1,1,1,1,1,1,1,2 => 26

    public static void main(String[] args) {
        int area = 0; // 계산된 넓이를 넣고 마지막에 출력할 변수
        int h; // 높이 (낮은 벽의 원소의 값)
        int w; // 밑변 (두 벽의 인덱스 차이)
        int temparea; // 비교할 넓이를 넣고 area랑 비교하기
        int[] height = {5,3,9,2,1,1,1,1,1,1,1,1,1,2};

        for (int i = 0; i < height.length; i++) {
            for (int j = height.length-1; j > i; j--) {
                w = j - i;
                h = Math.min(height[i], height[j]);
                temparea = w * h;
                if(temparea>area) {
                    area = temparea;
                }
            }
        }
        System.out.println(area);
    }
}
