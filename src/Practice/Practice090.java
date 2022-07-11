package Practice;

// 프로그래머스 Lv.3 Summer/Winter Coding(~2018) 기지국 설치
// https://programmers.co.kr/learn/courses/30/lessons/12979
// 풀긴 풀었으나 정답제출은 안함
public class Practice090 {
    public static int solution(int n, int[] stations, int w) {
        int cnt = 0;         // 기지국 개수
        int position = 1;   // 1동부터 시작
        int idx = 0;         // stations[] 내의 idx

        // 전파가 터지는 최대 위치 position
        while(position <= n) {
            // 기지국 설치 하지 않아도 되는 상황
            // 현 위치 position은 station[idx]으로부터 전파가 터지는 상황이다.
            if(idx < stations.length && stations[idx] - w <= position){
                // position에 2w + 1만큼 온전히 더할 수 없는 상황이니까 position을 변경한다.
                // stations[idx] - w 부터 stations[idx] + w 까지 전파 터지니까 그 다음으로 이동
                position = stations[idx] + w + 1;
                idx++;
                continue;
            }
            // 기지국 설치해야하는 상황
            cnt++;
            position += 2 * w + 1;
        }
        return  cnt;
    }
    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        System.out.println(solution(n, stations, w));

        n = 16;
        int[] stations2 = {9};
        w = 2;
        System.out.println(solution(n, stations2, w));
    }
}