package Practice;// 백준 2630 색종이 만들기
// https://www.acmicpc.net/problem/2630

/*
1. 아이디어
한 종이가 다 같지 않으면 자름
재귀호출로 반복
자를지 말지는 이중포문 돌면서 내부 모든 요소 비교..
+ 줄 건너 뛸 때 윗줄과 아랫줄도 비교해줘야함

2. 시간 복잡도
- 전체 종이 크기: N * N (N = 2^k, 1 <= k <= 7)
이중포문으로 요소 체크 시 O(N^2)
가장 잘게 자른다고 생각하면 O(2^7*2 = 2^14) => 1억번이 넘지 않아 가능

3. 자료구조
- 정수형 배열
- int: 파란색 종이
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice094 {
    static int[][] arr;
    static int blueCnt, whiteCnt, gap;
    static boolean cutFlag;
    // cut 풀이에 추가로 필요한 변수
    static int[] leftUpIdx, rightDownIdx;
    // cut2 풀이에 추가로 필요한 변수
    static int x, y;



    public static void solution(int gap) {
//        cut(new int[]{0,0}, new int[]{gap - 1, gap - 1}, gap - 1);
        cut2(0, 0, gap);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    public static void cut(int[] leftUpIdx, int[] rightDownIdx, int gap) {
        cutFlag = false; // 초기화
        // 1칸짜리 종이임
        if(Arrays.equals(leftUpIdx, rightDownIdx)) {
            if(arr[leftUpIdx[0]][leftUpIdx[1]] == 1) {
                blueCnt++;
            } else {
                whiteCnt++;
            }
            return;
        }
        // 다른 숫자가 있으면 잘라
        for (int i = 0; i <= gap; i++) {
            for (int j = 1; j <= gap; j++) {
                if(arr[leftUpIdx[0] + i][leftUpIdx[1]] != arr[leftUpIdx[0] + i][leftUpIdx[1] + j]) {
                    cutFlag = true;
                    break;
                }
            }
            if(i < gap && arr[leftUpIdx[0] + i][leftUpIdx[1] + gap] != arr[leftUpIdx[0] + i + 1][leftUpIdx[1]]) {
                cutFlag = true;
                break;
            }
            if(cutFlag) {
                break;
            }
        }
        // 잘라야 하면
        if(cutFlag == true) {
            gap = (rightDownIdx[0] - leftUpIdx[0]) / 2; // gap은 종이의 가로&세로 사이즈
            int next = gap + 1; // next는 다음 종이까지의 인덱스 차이
            cut(new int[]{leftUpIdx[0], leftUpIdx[1]}, new int[]{leftUpIdx[0] + gap, leftUpIdx[1] + gap}, gap); // 왼쪽 위
            cut(new int[]{leftUpIdx[0], leftUpIdx[1] + next}, new int[]{rightDownIdx[0] - next, rightDownIdx[1]}, gap); // 오른쪽 위
            cut(new int[]{leftUpIdx[0] + next, leftUpIdx[1]}, new int[]{rightDownIdx[0], rightDownIdx[1] - next}, gap); // 왼쪽 아래
            cut(new int[]{rightDownIdx[0] - gap, rightDownIdx[1] - gap}, new int[]{rightDownIdx[0], rightDownIdx[1]}, gap); // 오른쪽 아래
        } else {
            if(arr[leftUpIdx[0]][leftUpIdx[1]] == 1) {
                blueCnt++;
                return;
            } else {
                whiteCnt++;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gap = Integer.parseInt(br.readLine());
        arr = new int[gap][gap];

        for (int i = 0; i < gap; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < gap; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        solution(gap);
    }

    // 다른 풀이
    public static void cut2(int x, int y, int gap) {
        if(gap == 1) { // 1장짜리 종이면
            if(arr[x][y] == 1) {
                blueCnt++;
            } else {
                whiteCnt++;
            }
            return;
        }
        // 잘라야 하는지 확인
        for (int i = x; i < x + gap; i++) {
            for (int j = y; j < y + gap; j++) {
                if(arr[x][y] != arr[i][j]) {
                    cutFlag = true;
                    break;
                }
            }
            if(cutFlag) {
                break;
            }
        }
        // 잘라야 하면
        if(cutFlag) {
            cutFlag = false;
            // 재귀호출
           cut2(x, y, gap/2); // 왼쪽 위
           cut2(x, y + (gap/2), gap/2); // 오른쪽 위
           cut2(x + (gap/2), y, gap/2); // 왼쪽 아래
           cut2(x + (gap/2), y + (gap/2), gap/2); // 오른쪽 아래
        } else {
            if(arr[x][y] == 1) {
                blueCnt++;
            } else {
                whiteCnt++;
            }
        }
    }
}

/*
[학습내용]
재귀호출을 할 때는 기준이 되는 지점이 있어야 숫자가 꼬이지 않는다.
예를 들어, 재귀호출 시 넘겨주는 매개변수가 gap으로만 이루어져있으면 옆 종이들에서 변수 설정이 어려워진다.
x, y와 같이 재귀호출되어 들어올 때 넘겨받는 변수를 기준점으로 잡고 +- 하는것이 좋다.
 */