// 프로그래머스 Lv.1
// 크레인 인형뽑기 게임

import java.util.ArrayList;
public class Practice052 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        ArrayList<Integer> popArr = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][moves[i]-1]>0) {
                    if(popArr.size()>0 && board[j][moves[i]-1]==popArr.get(popArr.size()-1)) {
                        popArr.remove(popArr.size()-1);
                        answer = answer + 2;
                    } else {
                        popArr.add(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1]=0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }
}
