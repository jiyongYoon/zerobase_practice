package Practice;

public class Practice004 {
//    Q4. 별찍기
//    행과 타입을 입력했을 때 그에 따른 출력결과물이 아래와 같이 나오도록.
//    (아래는 행이 3일 때의 출력 결과)
//    타입 1    타입2     타입3       타입4     타입5
//    ***       *          *         *        *
//    ***       **        **        ***      ***
//    ***       ***      ***       *****      *
    public static void star(int line, int type) {
        if(line%2==1) {
            switch(type) {
                case 1:
                    for(int i=1; i<=line; i++) { // i는 해당 행
                        for(int j=1; j<=line; j++) { // j는 해당 행에서 동작 반복할 수
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2: // 해당 행의 숫자만큼 별을 찍는다는 개념으로
                    for(int i=1; i<=line; i++) {
                        for(int j=1; j<=i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 3: // case 1에서 공백을 찍는다는 개념으로
                    for(int i=1; i<=line; i++) {
                        for(int j=1; j<=line-i; j++) {
                            System.out.print(" ");
                        }
                        for(int k=1; k<=i; k++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 4: // 공백은 case 3과 동일, 별의 갯수는 해당 행*2-1, 별 다 찍으면 println.
                    for(int i=1; i<=line; i++) {
                        for(int j=1; j<=line-i; j++) {
                            System.out.print(" ");
                        }
                        for(int k=1; k<=i*2-1; k++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 5: // 가운데 행 위는 case 4로, 아래는 새로운 규칙...
                    // 가운데 행 까지
                    for(int i=1; i<=line/2+1; i++) {
                        for(int j=1; j<=line/2+1-i; j++) {
                            System.out.print(" ");
                        }
                        for(int k=1; k<=i*2-1; k++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    // 그 아래줄
                    for(int l=line/2+2; l<=line; l++) {
                        int z=0;
                        for(int m=line/2+1; m<l; m++) {
                            System.out.print(" ");
                            z++;
                        }
                        for(int n=1; n<=line-(z*2); n++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                default:
                    System.out.println("타입값 오류");
            }
        } else {
            System.out.println("행의 갯수가 짝수입니다.");
        }
    }

    public static void main(String[] args) {
        star(5,4);
        star(3, 5);
    }
}
/*
        [배운점]
        개인적으로 무척 어려웠음. 아직 정확하게 이해하지는 못했지만 그래도 배운점이 있다면,
        1) 별찍기 문제는 먼저 숫자간(별의 갯수, 줄의 갯수, 공백의 갯수)의 규칙성을 식으로 찾아내는 것이 관건.
        2) 처음 for문은 행에 대한 내용이며, 그 안의 for문은 별과 공백을 얼마나 찍을 것인지에 대한 내용.
        3) 마지막까지 일관된 규칙은 처음 for문 안에서 해결이 가능하나,
           마지막까지 일관되지 않은 규칙은 덩어리를 나누어 for문을 구성.
        3-1) 덩어리를 나누는 경우는 하단부 규칙은 숫자가 줄어들며 끝나야 하기 때문에 for문 안에서 --로 종료시켜주는것도 가능.
 */