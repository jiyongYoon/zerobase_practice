package Practice;// 코딩테스트 연습문제
// 문자열 압축 해제 ({ } 안을 앞 숫자만큼 반복)
// 입출력 예시: f2{a3{bc}}z -> fabcbcbcabcbcbcz

import java.util.ArrayList;
import java.util.Arrays;

public class Practice046 {
    // 가장 마지막 괄호를 찾아서 안에서부터 풀어나가는 식으로 코드 진행
    public static String decode(String code) {
        ArrayList<Character> arr = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        // 위 리스트는 숫자가 나오면 해독하러 들어가야해서 비교하기 위해 만든 리스트
        String tmpStr = ""; // 반복할 문자열 보관
        while (code.contains("{") || code.contains("}")) { // 더이상 { 나 } 가 없을때까지 반복
            int lIdx = 0; // 코드 반복과 몇번 반복할건지 기준이 될 인덱스, lIdx는 항상 숫자를 가리키게 됨
            int rIdx = lIdx; // 어디까지 반복할건지와 뒤에 더이상 } 가 없는지 확인할 인덱스
            // lIdx 위치 잡기
            while (rIdx < code.length()) { // rIdx로 맨 뒤까지 서치
                if (arr.contains(code.charAt(rIdx))) { // 숫자 나오면
                    lIdx = rIdx; // 거기에 lIdx 가져다 놓음
                }
                rIdx++; // 다시 끝까지 계속 감
            }
            // 해독부분( {} 괄호 푸는 부분 )
            int times = Integer.parseInt(code.substring(lIdx, lIdx + 1)); // 몇번 반복할건지, lIdx가 가리키고 있음.
            rIdx = lIdx; // rIdx를 lIdx 위치로 다시 오게해서
            while (code.charAt(rIdx) != '}') { // rIdx를 } 괄호 나올때까지 밀어
                rIdx++;
            }
            for (int i = 0; i < times; i++) { // 그 부분을 반복해서 tmpStr에 보관
                tmpStr += code.substring(lIdx + 2, rIdx);
            }
            code = code.substring(0, lIdx) + tmpStr + code.substring(rIdx + 1); // 기존 문자열 수정
            tmpStr = ""; // 반복할 문자열 초기화
        } // 이걸 반복
        return code;
    }

/*  다른 풀이 (재귀)

    static int idx = 0; // 재귀 전체에 쓰일 인덱스를 맴버변수로.

    public static String solution(String code) {
        return recursive(code);
    }

    public static String recursive(String s) {
        String answer = ""; // 수정해서 기록한 값을 받아줄 변수(정답)
        String tmp = ""; // 재귀에서 나온 값을 받아줄 변수
        int num = 0; // 반복할 횟수
        while(idx<s.length()) { // 인덱스가 맨 끝까지 갈때까지
            if(Character.isDigit(s.charAt(idx))) { // 숫자면
                num = Character.getNumericValue(s.charAt(idx)); // 보관하고
                idx++; // 한칸 뒤로
            } else if(s.charAt(idx)=='{') { // { 면
                idx++; // 한칸 뒤로
                tmp = recursive(s); // 재귀 호출
                answer += tmp.repeat(num); // 재귀 나오면 재귀에서 받아온 값을 정답에 기입
            } else if(s.charAt(idx)=='}') { // } 면
                idx++; // 한칸 뒤로
                break; // 재귀 탈출
            } else { // 문자면
                answer += s.charAt(idx); // 정답기입
                idx++; // 한칸뒤로
            }
        }

        return answer;
    }
*/

    public static void main (String[]args){
        System.out.println(decode("6{a2{b4{c}d}e}f"));
        System.out.println(decode("ab3{cd2{ef4{ge}hi}jk}lm"));
        System.out.println(decode("ab3{cd2{ef4{ge}hi}jk}lm5{qw3{we}}"));
        System.out.println(decode("ab3{cd2{ef4{ge}hi}jk}lm5{qw3{we}}5{z}2{a}"));
        System.out.println(decode("ab3{cd2{ef4{ge}hi}jk}lm5{qw3{we}}5{z}2{ahr}"));
    }
}
/*
[학습내용]
필요한 인덱스 활용하기.

[String에서 중간 문자를 지우는 방법]
String str = "Hello Java";
int eraseNum = 5;
<substring으로> - 중간에 뭘 추가하기 좋음
str = str.substring(0,eraseNum) + str.substring(eraseNum+1);
<deleteCharAt> - 빠르게 삭제하기 좋음
str = str.deleteCharAt(eraseNum);
<replace> - 인덱스를 모르더라도 문자를 알면 가능
str = str.replace(" ", "");
 */