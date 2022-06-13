package Practice;

import java.util.Scanner;
// 미해결
public class Practice003 {
    public static void main(String[] args) {
//        Q3. String 자료형 메서드 중 replace를 replace, indexOf, contains를 사용하지 않고 구현해보기.
//        "Hello Java, Nice to meet you! Java is fun!" -> "Hello 자바, Nice to meet you! 자바 is fun!"
//        "POP" -> "WOW"
//
        String a1;
        System.out.println("전체 문장을 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        a1 = sc.nextLine();

        String findArr; // 찾을 단어.
        System.out.println("찾을 단어를 입력하세요: ");
        findArr = sc.nextLine();

        String changeArr; // 바꿀 단어.
        System.out.println("바꿀 단어를 입력하세요: ");
        changeArr = sc.nextLine();

        StringBuffer outputArr = new StringBuffer(); // 마지막에 출력할 문장. 하나씩 쌓아둘 것.
        StringBuffer tempArr = new StringBuffer(); // 비교할 문장. 비교는 equals로 해야함.

        for(int i = 0; i<a1.length(); i++) {
            tempArr.append(a1.charAt(i));
        }
        System.out.println("기존 문장: " + tempArr);

        for(int j = 0; j<tempArr.length(); j++) {
            if(j+findArr.length()<tempArr.length() && tempArr.substring(j, j+findArr.length()).equals(findArr)) { // substring으로 가져온 것은 string 형.
                outputArr.append(changeArr);
                j=j+findArr.length()-changeArr.length()+2;
            } else {
                outputArr.append(tempArr.substring(j,j+1));
            }
        }

        System.out.println("바뀐 문장: " + outputArr);


//        for(int i = 4; i<a1.length(); i++) {
//            String temp = a1.substring(i-4, i);
//            tempArr.append(temp);
//            outputArr.append(tempArr);
//            outputArr.delete(outputArr.length()-3,outputArr.length());
//            tempArr.delete(0,tempArr.length());
//        }
//        System.out.println(outputArr);

//        String[] a1Arr = a1.split("");}

//        for(int i = 3; i< a1Arr.length; i++) {
//            tempArr.append(a1Arr[i-3]);
//            tempArr.append(a1Arr[i-2]);
//            tempArr.append(a1Arr[i-1]);
//            tempArr.append(a1Arr[i]);
//            outputArr.append(tempArr);
//            if(tempArr == findArr) {
//                outputArr.delete(outputArr.length(),3);
//                outputArr.append("자바");
//                i = i+3;
//            } else if(i== a1Arr.length-3) {
//
//            }
//            else {
//                outputArr.delete(outputArr.length()-3,outputArr.length());
//            }
//            tempArr.delete(0, tempArr.length());
//        }
//        System.out.println(outputArr);
    }
}
