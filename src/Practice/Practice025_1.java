package Practice;//    **기존 파일에서 다차원변수로 개선해보기**
import java.util.Scanner;

public class Practice025_1 {
//    미니과제8) 연소득 과세금액 계산 프로그램
//    소득세율 기준에 따라 세금을 구하는 프로그램 작성
//    1) 연소득 금액 입력
//    2) 종합소득세율표를 통해 조건 생성

    static void taxCal() {
        System.out.println("[과세금액 계산 프로그램]");
        Scanner sc = new Scanner(System.in);
        System.out.print("연소득을 입력해 주세요: ");
        long income = sc.nextInt();
        int pertax = 0; // 세율에 의한 세금
        int nujintax = 0; // 누진공제에 의한 세금
        int[][] taxgraph = new int[8][3]; // 0열: 범위(breakpoint) / 1열: 세율(perpoint) / 2열: 누진공제(nujinpoint)
        int[] nujinpoint = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000}; // 누진포인트
        int[] perpoint = {6, 15, 24, 35, 38, 40, 42, 45}; // 세율포인트
        int percase; // 세율케이스
        int[] breakpoint = {0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000}; // 과세포인트
        //소득세율표를 다차원배열에 입력하는 부분. 단, 입력을 위해 결국 정수형 배열들을 그대로 사용했는데,
//      //좀더 가독성 좋게 넣는 방법이 없을까...?
        for (int i = 0; i < 8; i++) {
            taxgraph[i][0] = breakpoint[i];
        }
        for (int i = 0; i < 8; i++) {
            taxgraph[i][1] = perpoint[i];
        }
        for (int i = 0; i < 8; i++) {
            taxgraph[i][2] = nujinpoint[i];
        }
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.printf("%10d  ", taxgraph[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println();
        //세율계산
        if(income<=breakpoint[1]) {
            percase = 1;
        } else if (income>breakpoint[1] && income <= breakpoint[2]) {
            percase = 2;
        } else if (income>breakpoint[2] && income <= breakpoint[3]) {
            percase = 3;
        } else if (income>breakpoint[3] && income <= breakpoint[4]) {
            percase = 4;
        } else if (income>breakpoint[4] && income <= breakpoint[5]) {
            percase = 5;
        } else if (income>breakpoint[5] && income <= breakpoint[6]) {
            percase = 6;
        } else if (income>breakpoint[6] && income <= breakpoint[7]) {
            percase = 7;
        } else {
            percase = 8;
        }
//        //세금계산
        switch (percase) {
            case 1:
                pertax = (int)income * taxgraph[percase-1][1] / 100;
                nujintax = pertax;
                System.out.printf("%10d * %2d%% = %10d\n\n", (int)income, taxgraph[percase-1][1], (int)income*taxgraph[percase-1][1]/100);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                nujintax = ((int)income * taxgraph[percase-1][1]/100) - taxgraph[percase-1][2];
                for (int i = 0; i < percase - 1; i++) { // 구간별 세금계산
                    pertax += (taxgraph[i+1][0]-taxgraph[i][0]) / 100 * taxgraph[i][1];
                    System.out.printf("%10d * %2d%% = %10d\n", (taxgraph[i+1][0]-taxgraph[i][0]), taxgraph[i][1], (taxgraph[i+1][0]-taxgraph[i][0]) / 100 * taxgraph[i][1]);
                }
                for (int i = 1; i < percase ; i++) { // 구간 돌때마다 남은 금액
                    income -= taxgraph[i][0]-taxgraph[i-1][0];
                }
                pertax += income /100 * taxgraph[percase-1][1]; // 마지막 남은 금액 세금계산
                System.out.printf("%10d * %2d%% = %10d\n\n", income, taxgraph[percase-1][1], income /100 * taxgraph[percase-1][1]);
                break;
            }
        //세금출력
        System.out.printf("%s\t\t\t %d\n", "[세율에 의한 세금]:", pertax);
        System.out.printf("%s\t %d", "[누진공제 계산에 의한 세금]:", nujintax);

//        switch (percase) {
//            case 1:
//                pertax = (int)income * perpoint[0] / 100;
//                nujintax = pertax;
//                System.out.printf("%10d * %2d%% = %10d\n\n", breakpoint[1], perpoint[0], breakpoint[1] / 100 * perpoint[0]);
//                break;
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//            case 6:
//            case 7:
//            case 8:
//                nujintax = (int)((income * perpoint[percase-1]) / 100) - (nujinpoint[percase-1]); // income이 변해서 누진공제 세금은 먼저 계산
//                for (int i = 0; i < percase - 1; i++) { // 구간별 세금계산
//                    pertax += (breakpoint[i+1]-breakpoint[i]) / 100 * perpoint[i];
//                    System.out.printf("%10d * %2d%% = %10d\n", (breakpoint[i+1]-breakpoint[i]), perpoint[i], (breakpoint[i+1]-breakpoint[i]) / 100 * perpoint[i]);
//                }
//                for (int i = 1; i < percase ; i++) { // 구간 돌때마다 남은 금액
//                    income -= breakpoint[i]-breakpoint[i-1];
//                }
//                pertax += income /100 * perpoint[percase - 1]; // 마지막 남은 금액 세금계산
//                System.out.printf("%10d * %2d%% = %10d\n\n", income, perpoint[percase-1], income /100 * perpoint[percase - 1]);
//                break;
//        }
//
    }

    public static void main(String[] args) {
        taxCal();
    }
}
/*
연소득 과세금액 계산 프로그램
[추가학습내용]
확실하게 계산할 때 가져올 변수가 무엇인지가 명확해진다!!
무엇보다, 변수에 대한 이름때문에 헷갈리지 않아서 좋다!!
그냥 다차원배열에서 행, 열만 신경쓰면 되며, 열은 표에서 1열, 2열, 3열로 가져오면 되기 때문!!

[추가개선할 내용]
표를 다차원배열에 입력하는 부분. 단, 입력을 위해 결국 정수형 배열들을 그대로 사용했는데,
좀더 가독성 좋게 넣는 방법이 없을까...?

[기존학습내용]
1) int의 범위가 생각보다.... 작다...!
   숫자가 갑자기 음수로 변하고 이상하게 틀어지면, 데이터형태의 크기를 의심해볼 것!
2) 데이터가 3 x 8 표이기 때문에 다차원 배열로 풀어도 가능했겠음.
   그 구간에서 계산해야 할 것을 미리 배열로 계산해두면 나중에 꺼내쓰기만 하면 될 듯.
3) printf("\t");에 대한 고찰
   탭은 단순한 '몇 칸 띄우기' 보다, 들여쓰기와 내어쓰기의 개념인 것으로 보임.
   따라서, 한글-숫자, 한글-영문 과 같이 한 글자의 점유길이가 다른 경우에는
   탭으로 간격조절을 하면 핸들링이 쉬워짐을 알아냄.
 */