package Practice;

// 프로그래머스 Lv.1
// 가운데 글자 가져오기
public class Practice064 {
    public String solution(String s) {
        String answer = "";
//        if(s.length() % 2 == 0) {
//            answer += s.substring((s.length()/2)-1, (s.length()/2)+1);
//        } else {
//            answer += s.substring((s.length()/2), (s.length()/2)+1);
//        }
        answer += (s.length()%2==0) ? s.substring((s.length()/2)-1, (s.length()/2)+1) : s.substring((s.length()/2), (s.length()/2)+1);

        return answer;
    }
}
/*
[학습내용]
조건에 따라 같은 변수에 값을 넣을때는 삼항연산자 표현 가능
 */
