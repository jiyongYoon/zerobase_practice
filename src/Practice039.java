// Stack 클래스를 활용하여 괄호 짝 맞추기
// 입출력 예시: ( -> false / )) -> false / ()() -> true / (()()) -> true

import java.util.Stack;


public class Practice039 {
    static boolean checkEven(String s1, String s2, String str) {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if(str.substring(i,i+1).equals(s1)) {
                stack.push(1);
            } else {
                if(stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if(stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkEven("(", ")", "((()))"));
        System.out.println(checkEven("(", ")", "(()))"));
        System.out.println(checkEven("(", ")", "()()(()())"));
        System.out.println(checkEven("[", "]", "[][[]]"));
        System.out.println(checkEven("1","2","121211221"));

    }
}
