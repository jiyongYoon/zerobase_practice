// 이진정렬 연습문제
// 정수형 배열 weights 와 정수 days가 주어짐
// weights에는 각 상품의 무게들의 정보가 있고, days는 운송 납기일
// 상품들은 weights에 적혀있는 순서대로 실어서 운송해야 하며,
// days 이내에 운송하기 위한 차량의 최소 적재량을 계산하는 프로그램 작성
public class Practice074 {
    public static int solution(int[] weights, int days) {
        int max = 0; // 최대 적재량
        int min = Integer.MIN_VALUE; // 최소 적재량

        for (int i = 0; i < weights.length; i++) {
            if(weights[i] > min) {
                min = weights[i];
            }
            max += weights[i];
        }
        // 이진정렬을 할 때 최소적재량은 배열 중 가장 큰 무게
        // 최대 적재량은 한번에 다 실었을 때의 무게
        // 그 사이에서 days 이내에 운송하기 위한 최소값을 이진정렬로 찾을 수 있음

        int cargo = (max + min) / 2; // 최소 적재량
        while(min <= max) { // 이진정렬에서 왼쪽값이 오른쪽 값보다 커질때 이진정렬 탈출
            int cnt = 0; // 일수
            cargo = (max + min) / 2; // 최소 적재량
            int once = 0; // 한번에 옮길 양
            // 물건 실기
            for (int i = 0; i < weights.length; i++) {
                if(once + weights[i] > cargo) { // 다음 것 까지 실었을 때 최소 적재량을 넘어가면
                    cnt++; // 한번 보냈고
                    once = 0; // 한번에 옮길 양 초기화
                }
                once += weights[i]; // 물건 실기
            }

            if(cnt < days) { // 보낸 일수가 요구한 날보다 작으면
                max = cargo - 1; // 더 작게 쪼개서 보낼수 있으니 이진정렬의 왼쪽 파티션에서 다시 시작
            } else { // 보낸 일수가 요구한 날보다 크거나 같으면
                min = cargo + 1; // 더 크게 보내야 하니 이진정렬의 오른쪽 파티션에서 다시 시작
            }
        }
        return min; // 파티션의 맨 앞 값 리턴
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(solution(weights, 5));
    }
}
