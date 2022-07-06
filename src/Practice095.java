// 백준 17829 222-풀링
// https://www.acmicpc.net/problem/17829

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice095 {
    public static int[][] grid;
    public static int n;
    public static int solution(int x, int y, int n) {
        return pulling(0, 0, n);
    }

    // 사각형이 더 쪼갤 수 있으면 재귀호출
    public static int pulling(int x, int y, int n) {
        // 마지막 재귀에 도착했을땐 2x2 배열일때.
        // 이때 a,b,c,d를 가지고 2번째 숫자 구해줘서
        int a = grid[x][y];
        int b = grid[x+1][y];
        int c = grid[x][y+1];
        int d = grid[x+1][y+1];
        // 만약 2보다 크면 계속 재귀 먼저 들어감
        // 그리고 다 하고 나올때는 거기서 계산해온 2번째 큰 값 가지고 나옴
        if(n != 2) {
            a = pulling(x, y, n / 2);
            b = pulling(x, y + (n / 2), n / 2);
            c = pulling(x + (n / 2), y, n / 2);
            d = pulling(x + (n / 2), y + (n / 2), n / 2);
        }
        // pulling 재귀함수의 리턴값으로 밖으로 내보냄
        return secondNum(a, b, c, d);
    }
    // 2번째 큰 수 추출, 매개변수는 2X2 배열의 구성요소
    public static int secondNum(int a, int b, int c, int d) {
        int[] arr = new int[4];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
        Arrays.sort(arr);
        return arr[2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(s[j]);
            }
        }
        System.out.println(solution(0, 0, n));
    }
}

/*
[학습내용]
들어가면서 계산해서 끝내는게 아니라 다 들어간다음에 나오면서 계산을 완성해가는 것은
재귀해서 나온 값을 변수에 받아나와야 한다.
 */
