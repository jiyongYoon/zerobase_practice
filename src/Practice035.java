//백준 2588번 응용
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

        space(idx(result)-idx(a));
        System.out.println(a);

        System.out.print("x");
        space(idx(result)-idx(Integer.parseInt(b))-1);
        System.out.println(b);
        line(idx(result));
        int tmp = 0;
        for (int i = arr.length-1; i >=0; i--) {
            arr[i] = Integer.parseInt(b.substring(i,i+1));
            space(idx(result)-idx(a*arr[i])-tmp);
            System.out.print(a*arr[i]);
            space(tmp);
            System.out.println();
            tmp++;
        }
        line(idx(result));
        System.out.println(result);
    }

    public static void main(String[] args) {
        times(123, "123");
    }
}
