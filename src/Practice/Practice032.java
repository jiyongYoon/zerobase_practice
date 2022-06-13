package Practice;//Q7. 팰린드롬(회문)
//- 앞 뒤가 똑같으면 회문
//- 그 중 한 글자를 지워서 같아지면 유사회문
//- 그래도 안되면 무관
//- 회문: 0, 유사회문: 1, 무관: 2를 출력하는 프로그램 만들기.
// <입출력예시> abba -> 0 / summuus -> 1 / comcom -> 2

public class Practice032 {
    static int solution(String str) {
        return felin(0, str.length()-1, str.toCharArray(), 0);
    }
    static int felin(int lIdx, int rIdx, char[] arr, int delCnt) {
        while(lIdx<rIdx) {
            if(arr[lIdx]!=arr[rIdx]) {
                if(delCnt==0) {
                    if(felin(lIdx+1, rIdx, arr, 1)==0 || felin(lIdx, rIdx-1, arr, 1)==0) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    return 2;
                }
            } else {
                lIdx++;
                rIdx--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] str = {"abba", "summuus", "xabba", "comcom", "comwwmoc", "comwwtmoc"};
        System.out.println(solution("abba"));
        System.out.println(solution("summuus"));
        System.out.println(solution("xabba"));
        System.out.println(solution("comcom"));
        System.out.println(solution("comwwmoc"));
        System.out.println(solution("comwwtmoc"));
    }
}
/*
[학습내용]
종료조건에 재귀를 사용하는것도 가능함.
 */