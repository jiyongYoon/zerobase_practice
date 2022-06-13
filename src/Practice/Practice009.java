package Practice;

public class Practice009 {
    // 핵좌절
    public static void klog(int[] inputInt) {
        final int backSpace = 8;
        final int shift = 16;
        final int capsLock = 20;
        final int spaceBar = 32;
        final int left = 37;
        final int right = 39;
        final int insert = 155;
        final int delete = 127;
        final int step = (int)('a' - 'A'); // 알파벳 숫자의 차이를 정수형으로 형변환

        StringBuffer sb = new StringBuffer(); // 결과값
        int Index = 0; // 커서
        boolean Shift = false; // 쉬프트
        boolean CapsLock = false; // 캡스락
        boolean Insert = false; // 캡스락

        for (int i = 0; i < inputInt.length; i++) {

            switch (inputInt[i]) {
                case backSpace: //ok
                    if(Index>0) {
                        sb.delete(Index-1, Index);
                        Index--;
                    }
                    break;
                case shift:
                    Shift = true;
                    break;
                case capsLock:
                    CapsLock = !CapsLock;
                    break;
                case spaceBar: //ok
                    sb.insert(Index, " ");
                    Index++;
                    break;
                case left: if(Index>0) {Index--;} //ok
                    break;
                case right: if(Index<sb.length()) {Index++;} //ok
                    break;
                case insert:
                    Insert = !Insert;
                    sb.insert(Index, (char)inputInt[i+1]);
                    sb.delete(Index+1, Index+2);
                    break;
                case delete: //ok
                    if(Index<sb.length()) {
                        sb.delete(Index, Index+1);
                    }
                    break;
            } // case 끝

            // 문자동작
            if(inputInt[i]>=97&&inputInt[i]<=122) {
                int data = inputInt[i];
                if(CapsLock && Shift) {
                    data = inputInt[i];
                } else if(CapsLock || Shift) {
                    data = data-step;
                }
                inputData(sb, (char)data, Index, Insert);
                Shift = false; // 쉬프트 초기화

            } else if(inputInt[i]>=48&&inputInt[i]<=57) {
                if(Shift) {
                    char[] specialKey = {')','!','@','#','$','%','^','&','*','('};
                    inputData(sb, specialKey[inputInt[i] - '0'], Index, Insert);
                } else {
                    inputData(sb, (char)inputInt[i], Index, Insert);
                }

                // 데이터 입력
                Shift = false; // 쉬프트 초기화
            }
        }
        System.out.println(sb.toString());
    }

    // 데이터 입력은 따로 메서드를 만들어서 메서드로 추가.
    public static void inputData(StringBuffer sb, char data, int Index, Boolean Insert) {
        if(Insert==false) {
            sb.insert(Index, data);
        } else {
            sb.setCharAt(Index, data);
        }
    }

    public static void main(String[] args) {
        klog(new int[]{16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104});
        klog(new int[]{20, 104, 16, 105, 32, 20, 16, 106, 97, 118, 97});
        klog(new int[]{49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53});
        klog(new int[]{20, 65, 66, 16, 67, 16, 68, 49, 50, 51});
    }
}