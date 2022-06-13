package Practice;//Q8. "+,-,*"로 이루어진 1차방정식 프로그램
//해가 없으면 "No solution", 해가 무한대이면 "infinite solutions", 해가 있으면 "x=__"형태로 출력

public class Practice033 {
    public static String solution(String input) {
        String[] inputstr = input.split("=");
        int[] leftside = sort(inputstr[0]);
        int[] rightside = sort(inputstr[1]);

        if (leftside[0] == rightside[0] && leftside[1] == rightside[1]) {
            return "infinite solutions";
        } else if (leftside[0] == rightside[0]) {
            return "No solution";
        } else {
            return "x=" + (rightside[1] - leftside[1]) / (leftside[0] - rightside[0]);
        }
    }

    public static int[] sort(String str) {
        int[] side = new int[2]; // 배열(x계수, 상수)
        boolean minus = false;
        int idx = 0;
        while (idx != str.length()) {
            char c = str.charAt(idx++);
            if (c == '+') {
                continue;
            }
            if (c == '-') {
                minus = true;
                continue;
            }

            if (c == 'x') {
                side[0] += minus ? -1 : 1;
            } else {
                if (idx < str.length() && str.charAt(idx) == 'x') {
                    side[0] += minus ? -(c - '0') : (c - '0');
                } else {
                    side[1] += minus ? -(c - '0') : (c - '0');
                }
            }
            minus = false;
        }
        return side;
    }

    public static void main(String[] args) {
        String inputstr = "x+5-3+x=6+x-2";
        System.out.println(solution(inputstr));
    }

    //정규표현식
    public static int[] sort2(String str) {
        int[] side = new int[2];

        for(String s : str.split("(?=[+-])")) {
            if (s.equals("+x") || s.equals("x")) {
                side[0]++;
            } else if (s.equals("-x")) {
                side[0]--;
            } else if (s.contains("x")) {
                side[0] += Integer.parseInt(s.substring(0,s.length()-1));
            } else {
                side[1] += Integer.parseInt(s);
            }
        }
        return side;
    }
}

/*
[학습내용]
방정식에서 해를 구할 때는
1) 계수만 배열을 가지고 계산
2) +,-는 boolean
**정규표현식**
https://coding-factory.tistory.com/529
 */
