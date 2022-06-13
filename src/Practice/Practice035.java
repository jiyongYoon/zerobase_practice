package Practice;//백준 2588번 응용
//곱셈을 하는 프로그램 작성
//세로로 계산하는 것을 그대로 출력하기

public class Practice035 {
    public static void space(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
    public static void line(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static int idx(int result) {
        int a=0;
        while(result>0) {
            result = result/10;
            a++;
        }
        return a;
    }

    public static void times(int a, String b) {
        int[] arr = new int[b.length()];
        int result = a * Integer.parseInt(b);
        int resultIdx = idx(result);

        if(idx(result)<=arr.length+1) {
            resultIdx = arr.length+1;
        }

        //출력부
        //수식부분
        space(resultIdx-idx(a));
        System.out.println(a);
        System.out.print("x");
        space(resultIdx-idx(Integer.parseInt(b))-1);
        System.out.println(b);
        //계산부분
        line(resultIdx);
        int tmp = 0;
        for (int i = arr.length-1; i >=0; i--) {
            arr[i] = Integer.parseInt(b.substring(i,i+1));
            space(resultIdx-idx(a*arr[i])-tmp);
            System.out.print(a*arr[i]);
            space(tmp);
            System.out.println();
            tmp++;
        }
        line(resultIdx);
        //결과부분
        space((arr.length+1)-idx(result));
        System.out.print(result);
    }

    public static void main(String[] args) {
        times(314, "945");
    }
}
