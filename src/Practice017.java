import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Practice017 {
//    미니과제 2.
//    문장의 각 영문 알파벳 별 출현 빈도의 개수를 구하고,
//    전체 알파벳 중 몇 % 비율로 나오는지를 구하는 프로그램 작성.
//    1) 전체 문자열의 길이는 String.length() 사용
//       (실제로는 문자의 개수만을 전체 길이로 구현해보았음)
//    2) 문자열(String)에서 특정 자리의 문자를 가져오는 String.charAt(index) 사용
//    3) 대소문자 구분하지 않음
//    4) 출력 형식은 오른쪽과 같은 포멧으로 일치시킬 것 / A =    455개,   5.67%
//    5) 내용은 텍스트 파일에서 읽어오며, 파일에서 텍스트를 가져오는 소스는 추가 클래스 참조

    static String txtRead(String fileName) {
        System.out.println(fileName+"의 내용입니다.");
        //파일 읽어오기
        String allStr = "";
        String wrap = "./"+fileName;
        try {
            BufferedReader br = new BufferedReader(new FileReader(wrap));
            while(true) {
                String str = br.readLine();
                if(str==null) {
                    break;
                }
                allStr += str;
//                System.out.println(str);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다.");
            e.getStackTrace();
        }
        return allStr;
    }

    static void txtCount(String txt) {
        String tempStr = ""; // 지금까지 나온 글자 저장
        ArrayList<String> orderStr = new ArrayList<>();
        int txtcount = 0; // 해당 글자 수 // 없어도 될듯
        double per = 0; // 해당 글자수의 퍼센트
        int azcount = 0; // A-Z까지 글자수 카운트

        // 글자 정렬
        for (int i = 0; i < txt.length(); i++) {
            String s = (Character.toString(txt.charAt(i))).toUpperCase(); // 본문알파벳을 대문자로
            if(orderStr.contains(s)) {
            } else {
                tempStr = s;
                orderStr.add(tempStr);
            }
        }
        orderStr.sort(Comparator.naturalOrder());
//        System.out.println(orderStr);

        // 전체 중 A-Z의 글자 수
        for (int i = orderStr.indexOf("A"); i <= orderStr.indexOf("Z"); i++) {
            for (int j = 0; j < txt.length(); j++) {
                // A-Z까지 각 글자수를 전체에서 카운트해서 숫자 넣기
                if((orderStr.get(i)).equals((Character.toString(txt.charAt(j))).toUpperCase())) {
                    txtcount++;
                }
            }
            azcount+=txtcount;
            txtcount=0;
        }
//        System.out.println(azcount);

        // 각 글자 카운트하여 출력
        for (int i = orderStr.indexOf("A"); i <= orderStr.indexOf("Z"); i++) {
            for (int j = 0; j < txt.length(); j++) {
                // A-Z까지 각 글자수를 전체에서 카운트해서 숫자 넣기
                if((orderStr.get(i)).equals((Character.toString(txt.charAt(j))).toUpperCase())) {
                    txtcount++;
                }
            }
            per = (double)txtcount / (double)azcount * 100;
            System.out.printf("%s : %6d개, %8.2f%%\n", (orderStr.get(i)), txtcount, per);
            txtcount = 0;
        }

        System.out.println("---------------");
    }

    public static void main(String[] args) {
        txtCount(txtRead("speach.txt"));
        txtCount(txtRead("atoz.txt"));
    }
}

/*
        [학습내용]
        *구현하고 나면 실무에서 어떤 형태가 더 편할지 고민해보는 습관!!*

        1) List<제네릭스>에서도 equals를 통한 비교가 가능함.
           ex) (객체.get(1)).equals("Java")      // 62, 75번째 줄
        2) String 메서드에서 .charAt의 값은 character로 취급.
           Character.toString(객체.charAt(0))으로 String 변환 가능. // 48, 62, 75번째 줄
        3) String 포메팅에서 공간여백과 소숫점자리수 동시 표현 가능함.
           ("%5.2f", 실수형 변수)                // 80번째 줄
           => 오른쪽 정렬, 공간을 총 5개 점유, 소수점은 2자리까지(3째자리 반올림)
 */