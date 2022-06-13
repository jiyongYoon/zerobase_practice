package Practice;// 연습문제
// 특별한 규칙으로 수열 만들기 프로그램
import java.util.Stack;
// 클래스를 만들어 사용하는 경우
class Input {
    int data;
    Input() {
    }
    Input(int data) {
        this.data = data;
    }
}

public class Practice057 {
    public static String solution(int[] arr) {
        String answer = "";
        int arrIdx = 0;
        // 1) 클래스를 만들어서 stack의 요소로 사용하는 경우
        Stack<Input> stack = new Stack<>(); // 제너릭스를 해당 클래스로 설정해야!!
        for (int i = 0; i < arr.length; i++) {
            stack.push(new Input(i+1));
            answer += "+";
            Input cur = stack.peek(); // 내부 변수 접근 시 객체를 만들고 그 객체의 . 연산자로 접근!!
            if(cur.data == arr[arrIdx]) {
                while(stack.size() != 0 && cur.data == arr[arrIdx]) {
                    if(cur.data == arr[arrIdx]) {
                        stack.pop();
                        arrIdx++;
                        answer += "-";
                    }
                    if(!stack.isEmpty()) {
                        cur = stack.peek();
                    }
                }
            }
        }
        /* 일반적인 풀이방법
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= arr.length; i++) {
            stack.push(i);
            answer += "+";
            if(stack.peek() == arr[arrIdx]) {
                while(stack.size() != 0 && stack.peek() == arr[arrIdx]) {
                    stack.pop();
                    arrIdx++;
                    answer += "-";
                }
            }
        }
        */
        if(stack.isEmpty()) {
            return answer;
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,3,6,8,7,5,2,1}));
        System.out.println(solution(new int[]{1,2,5,3,4}));
    }
}
/*
[학습내용]
1) 클래스는 설계도면이다. 내가 만들고자 하는 형태를 만들 수 있고, 이것이 사용자 자료형이다.
이런 경우, 제네릭스도 내가 만든 자료형으로 지정해주어야 한다.
-> 원시 자료형이 아닌 자료형에는 내가 만든것들이 들어갈 수 있겠다. (맵, 셋, 리스트, 배열 등)
2) 객체의 내부 변수에 접근할 때는 변수로 받아준 후 . 연산자를 사용하여 접근한다.
 */