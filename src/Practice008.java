import java.util.Scanner;
public class Practice008 {
//    Q8. 문자 편집기 구현
//    L: 커서를 왼쪽으로 한 칸 옮김(커서가 맨 앞이면 무시)
//    D: 커서를 오른쪽으로 한 칸 옮김(커서가 맨 뒤면 무시)
//    B: 커서 왼쪽에 있는 문자를 삭제(커서가 맨 앞이면 무시)
//    P x: x라는 문자를 커서 왼쪽에 추가
//    초기 커서는 문장 맨 뒤에서 시작

    public static void main(String[] args) {
        // 초기 문자열 입력받기
        StringBuffer sb = new StringBuffer();
        System.out.print("초기 문자열 입력: ");
        Scanner sc = new Scanner(System.in);
        sb.append(sc.nextLine());
        // 명령어 입력받기
        System.out.println("명령어 입력: ");
        Scanner sc2 = new Scanner(System.in);
        String let = sc2.nextLine();
        // 명령어를 배열로 만들기
        String[] letArr = let.split(" ");
        // 커서 위치
        int index = sb.length();
        // 케이스 별로 커서 움직이기
        for (int i = 0; i < letArr.length; i++) {
            switch(letArr[i]) {
                case "L":
                    if(index>0) {index--;}
                    break;
                case "D":
                    if(index<sb.length()) {index++;}
                    break;
                case "B":
                    if(index>0) {sb.delete(index-1,index);}
                    break;
                case "P":
                    sb.insert(index,letArr[i+1]);
                    index++;
                    break;
                default: break;
            }
        }
        System.out.println(sb);
    }
}
/*
        [학습내용]
        1) 문자를 계속해서 편집할때는 StringBuffer를 사용.
        2) StringBuffer이나 Stream같이 연속적인 데이터 변화가 있는 경우에
           디버거의 효율이 극대화 되는 것 같다. 문제를 디버거로 찾아내서 금방 해결!!
 */