package Practice;// 투포인터 연습문제
// 문자열 s를 거꾸로 출력하는 프로그램
// 공백이 있을 경우 한개의 공백을 제외한 나머지 공백은 제거

public class Practice079 {
    public static void solution(String s) {
        StringBuffer sb = new StringBuffer();
        // 맨 뒤에서부터 시작하는 포인터
        int p1 = s.length() - 1;
        int p2 = s.length() - 1;
        // p1, p2가 맨 앞에 도달할때까지
        while(p1 != 0 && p2 != 0) {
            if(s.charAt(p1) == ' ') { // 공백이면 공백 아닐때까지 p1 이동
                while(!Character.isAlphabetic(s.charAt(p1)) && p1 != 0) {
                    p1--;
                }
                p2 = p1; // p2 당겨오고
                sb.append(' '); // 공백은 1개만 추가
            // 문자면
            } else if(Character.isAlphabetic(s.charAt(p1)) && p1 != 0) {
                while(Character.isAlphabetic(s.charAt(p1)) && p1 != 0) {
                    p1--; // 문자아닐때까지 p1 이동
                }
                if(p1 == 0) { // 맨 앞까지 도착했으면
                    sb.append(s.substring(p1, p2 + 1)); // p1 ~ p2+1까지 추가
                } else { // 맨 앞이 아니면
                    sb.append(s.substring(p1 + 1, p2 + 1)); //p1+1 ~ p2+1까지 추가
                    p2 = p1; // p2 당겨오고
                }
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        String s = "the sky is blue";
        solution(s);

        s = "     hello        java   ";
        solution(s);
    }
}