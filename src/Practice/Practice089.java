package Practice;// 백준 1931번 회의실 배정
// https://www.acmicpc.net/problem/1931

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Practice089 {
    static class Meeting {
        long start;
        long end;
        Meeting() {};
        Meeting(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void solution(Long[][] arr, int N, ArrayList<Meeting> mt, int a) {
        int answer = a;
        Long curTime = 0L;
        for (Meeting item : mt) {
            if(curTime <= item.start) {
                curTime = item.end;
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 0;
        Long[][] arr = new Long[N][2];
        for (int i = 0; i < arr.length; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Long.parseLong(s[0]);
            arr[i][1] = Long.parseLong(s[1]);
        }
        ArrayList<Meeting> mt = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            mt.add(new Meeting(arr[i][0], arr[i][1]));
        }
        // 정렬을 할 때 두가지 조건으로 정렬할 수 있나? 1번은 end 순으로, 2번은 start 순으로
        Collections.sort(mt, (x1, x2) -> (int)(x1.start - x2.start));
        Collections.sort(mt, (x1, x2) -> (int)(x1.end - x2.end));
        solution(arr, N, mt, a);
    }
}

/*
[학습내용]
Collection.sort에서 정렬을 2가지 조건으로 해야할 때는
2순위 조건으로 먼저 정렬을 하고
1순위 조건으로 마지막에 정렬을 하면 됨.
 */

/*
[다른풀이]
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());	// 회의 수
		int[][] time = new int[N][2];	// 회의 시간
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[1] == o1[1]) {	// 종료시간이 같으면
					return o1[0] - o2[0]; // 시작시간 순대로 정렬하기!!
                } else {               // 종료시간이 다르면
                    return o1[1] - o2[1]; // 종료시간대로 정렬
                }
			}
		});

		int count = 1;
		int com = time[0][1];
		for (int i = 1; i < N; i++) {
			if(com <= time[i][0]) {
				count++;	// 끝나기 전에 시작시간이 잡히면 패스
				com = time[i][1];
			}
		}
		System.out.println(count);
	}
}
 */
