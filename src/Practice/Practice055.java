package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Practice055 {
    public static int times = 0;
    public static int[][] board;
    public static String curDir = "R";
    public static final int[] UP = {-1,0};
    public static final int[] RIGHT = {0,1};
    public static final int[] DOWN = {1,0};
    public static final int[] LEFT = {0,-1};
    public static int dirkey = 2;
    public static HashMap<Integer, String> dir;
    public static HashMap<Integer, String> movesMap;

    public static int solution(int N, int K, int L, int[][] apples, HashMap<Integer, String> moves) {
        ArrayList<int[]> v = new ArrayList<>();
        board = new int[N+1][N+1]; // 말판
        int[] head = new int[]{1, 1};
        dir = new HashMap<>();
        dir.put(1, "U");
        dir.put(2, "R");
        dir.put(3, "D");
        dir.put(4, "L");

        v.add(head.clone()); // 뱀 현재 위치

        movesMap = moves;

        // 말판에 사과 놓기
        for (int i = 0; i < apples.length; i++) {
            board[apples[i][0]][apples[i][1]] = 1;
        }

        while (true) {
            int[] appleCheck = head.clone();
            // 방향 가져오기
            if (movesMap.containsKey(times)) {
                curDir = getcurDir(times);
            }
            // 움직임
            if (curDir.equals("U")) {
                head[0] += UP[0];
                head[1] += UP[1];
            } else if (curDir.equals("R")) {
                head[0] += RIGHT[0];
                head[1] += RIGHT[1];
            } else if (curDir.equals("D")) {
                head[0] += DOWN[0];
                head[1] += DOWN[1];
            } else {
                head[0] += LEFT[0];
                head[1] += LEFT[1];
            }
            // 밖으로 나가거나 나를 만나면
            if (head[0] > N - 1 || head[1] > N - 1 || head[0] < 1 || head[1] < 1 || v.contains(head)) {
                return times;
            }
            // 움직일 수 있으면 한칸 움직이기
            v.add(head.clone());
            // 사과 만나면
            if(board[head[0]][head[1]] == 1) {
                board[head[0]][head[1]] = 0;
            } else { // 사과 없으면
                v.remove(0); // 뱀 꼬리 짜르기
            }
            times++; // 1초 지남
        }
    }

        // 방향구하기 메서드
        public static String getcurDir ( int times){
            if (movesMap.get(times).equals("D")) {
                dirkey = (dirkey == 4) ? 1 : dirkey + 1;
            } else {
                dirkey = (dirkey == 1) ? 4 : dirkey - 1;
            }
            return dir.get(dirkey);
        }

    public static void main(String[] args) {
        HashMap<Integer, String> moves = new HashMap<>();
        int[][] apples = new int[][] {{3,4},{2,5},{5,3}};
        moves.put(3,"D");
        moves.put(15,"L");
        moves.put(17,"D");
        System.out.println(solution(6,3,3,apples,moves));

//        apples.add(new int[]{1,2});
//        apples.add(new int[]{1,3});
//        apples.add(new int[]{1,4});
//        apples.add(new int[]{1,5});
//        moves.put(8,"D");
//        moves.put(10,"D");
//        moves.put(11,"D");
//        moves.put(13,"L");
//        System.out.println(solution(10,4,4,apples,moves));

//        apples.add(new int[]{1,5});
//        apples.add(new int[]{1,3});
//        apples.add(new int[]{1,2});
//        apples.add(new int[]{1,6});
//        apples.add(new int[]{1,7});
//        moves.put(8,"D");
//        moves.put(10,"D");
//        moves.put(11,"D");
//        moves.put(13,"L");
//        System.out.println(solution(10,5,4,apples,moves));

    }
}
