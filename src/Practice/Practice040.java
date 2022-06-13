package Practice;// 입력된 문자열 비교하기
// 문자열에 #이 붙어있으면 그 앞 문자를 삭제하여 비교
// 입출력 예시: s1=tree, s2=th#ree -> true / s1=soo#s, s2=so#oss# -> true

import java.util.Stack;
public class Practice040 {
    static String sortStr(String str) {
        Stack stack = new Stack();
        String result = "";
        //stack에 넣는 부분
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("#")) {
                if (str.substring(0, 1).equals("#")) {
                } else {
                    stack.pop();
                }
            } else {
                stack.push(str.substring(i, i + 1));
            }
        }
        //stack에서 빼는 부분
        String revStr = "";
        while (stack.empty() != true) {
            revStr += stack.pop();
        }
/*
        for (int i = 0; i < stack.size(); i++) {
            result += stack.pop();
        }
        -> 스택을 뺄수록 스택사이즈가 바뀌어 원하는대로 for문을 다 돌지 않음...
*/
        //뺀 값 뒤집는 부분
        for (int i = revStr.length(); i > 0; i--) {
            result += revStr.substring(i - 1, i);
        }
        return result;
    }
    static boolean compareStr(String s1, String s2) {
        if(sortStr(s1).equals(sortStr(s2))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(compareStr("tree", "th#ree"));
        System.out.println(compareStr("soo#s", "so#oss#"));
        System.out.println(compareStr("soo#s", "so#oss"));
    }
}

/*
[학습내용]
for문을 돌때 스택에 자료를 push, pop하게 되면 사이즈가 바뀌게 됨을 유의.
for (int i = 0; i < stack.size(); i++) {
    result += stack.pop();
} -> 이러면 반밖에 못돔
*/