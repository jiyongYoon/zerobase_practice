package Practice;// 백준 5904번 moo게임
// https://www.acmicpc.net/problem/5904

/*
1. 아이디어
s(0) = "moo" / length = 1 + 2 = 3
s(1) = s(0) + m + o + oo + s(0) / length = 3 + 4 + 3 = 10
s(2) = s(1) + m + oo + oo + s(1) / length = 10 + 5 + 10 = 25
s(n) =     / length = 2 * s(n-1) + n + 3

s(1) = s(0) + mooo + s(0)
s(2) = s(0) + mooo + s(0) + moooo + s(0) + mooo + s(0)
s(3) = s(0) + mooo + s(0) + moooo + s(0) + mooo + s(0)
                          + mooooo
     + s(0) + mooo + s(0) + moooo + s(0) + mooo + s(0)
길이는 가운데가 1개씩 늘어나고 좌우는 기존길이 * 2
N번째 글자를 출력하려면 s 몇까지 가야하는지 구한 후 String을 구해서 카운트 해주자

2. 시간복잡도
- 1 <= N <= 10^9 = 1,000,000,000 = 10억...
길이로 s(k)의 k값을 구한 후 N까지 m의 위치를 구하기

-- 다시 --

1. 아이디어
입력되는 N이 포함되려면 S(K)에서 K가 몇인지 먼저 구함.
그리고 moo 수열의 왼쪽부 / 중앙부 / 오른쪽부 인지를 재귀로 따지고 들어감.

2. 시간복잡도
10^9을 1이 될때까지 3등분

3. 자료구조
s.length => long
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice096 {
    public static void solution(long n) {
        long l = 0; // moo(k)의 길이
        long k = 0;
        while(l < n) { // n이 되려면 몇번째 moo까지 가야하는지 구하기
            l = mooLeng(k);
            k++;
        }
        k--;

        if(k > 0) {
            while (n > 3) { // moo(0) 즉, 3이 될때까지 재귀로 파고 들어가기
                long midLeft = (long) (Math.ceil((double)l / 2)) - 1 - (k / 2); // 가운데 추가되는 m위치
                long midRight = midLeft + k + 2; // 가운데 마지막으로 추가되는 o위치
                if (n == 0 || n == midRight + 1) { // 빠르게 탈출하는 조건 추가
                    System.out.println("m");
                    return;
                }
                if (n >= 0 && n < midLeft) { // leftMoo 부분
                    l = midLeft - 1; // 왼쪽부분에서 다시 moo 확인
                    k--;
                } else if (n >= midLeft && n < midRight) { // midMoo 부분
                    if (n == midLeft) {
                        System.out.println("m");
                        return;
                    } else {
                        System.out.println("o");
                        return;
                    }
                } else { // rightMoo 부분
                    l = midLeft - 1; // 구조는 왼쪽부분이랑 같기 때문에 왼쪽으로 봐도 됨
                    k--;
                    n = n - midRight; // 대신 n은 줄여줘야함.
                }

            }
        }
        // moo(0), 즉 끝까지 파고 들어갔을 때 m인지 o인지 판단하여 출력
        if (n == 1) {
            System.out.println("m");
        } else {
            System.out.println("o");
        }
    }

    // moo(k)는 길이가 얼마인지 구하는 메서드
    public static long mooLeng(long k) {
        if(k == 0) {
            return 3;
        }
        return (2 * mooLeng(k - 1)) + (k + 3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        solution(n);
    }
}

/* 다른풀이
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		stack.add(3);
		int now=3, k=1;
		while(now<=N) {
			now = ((now*2)+k+3);
			stack.add(now);
			k++;
		}

		//k+2
		char answer;
		while(true) {
			int len = stack.pop();
			if(N<=stack.peek()) {
				k--;
				continue;
			}
			if((stack.peek()+(k+2))>=N) {
				if(N==(stack.peek()+1)) answer='m';
				else answer='o';
				break;
			}
			else
				N-=(stack.peek()+k+2);
			k--;
		}

		System.out.println(answer);
	}
}

다른풀이 2
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        //입력한 n 이 몇 번째 수열에 포함되는지?
        //totLength = 수열 전체 길이, midLength = o가 k+2개인 부분 길이
        //초기 상태 : moo
        int totLength = 3;
        int midLength = 3;

        //n이 현재 수열의 길이보다 크면 수열 계속 늘려주기
        while(n > totLength) {
            totLength = totLength * 2 + ++midLength;
        }

        while(true) {
            //t 는 이전 문자열의 길이
            int t = (totLength - midLength) / 2;

            //n이 첫 번째 부분이면
            //o가 k+2개인 부분의 길이를 1 줄여주고, 전체 길이를 이전 문자열의 길이로
            if(n <= t) {
                midLength--;
                totLength = t;
            }
            //n이 세 번째 부분이면
            //이전 문자열의 길이 만큼 줄여주며 사라진 만큼 n도 줄여준다
            //o가 k+2개인 부분의 길이를 1 줄여주고, 전체 길이를 이전 문자열의 길이로
            else if(n > t + midLength) {
                n -= t + midLength;
                midLength--;
                totLength = t;
            }
            //n이 중간 부분이면
            //n에서 이전 문자열의 크기만 빼준다.
            else {
                n -= t;
                break;
            }
        }
        bw.append(n == 1 ? "m" : "o");
        bw.flush();
        bw.close();
        br.close();
    }
}
 */