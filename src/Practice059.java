// 연습문제
// 완주 못한 사람 출력하기
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Practice059 {
    public static String solution(String[] parti, String[] comp) {
        ArrayList<String> partiList = new ArrayList<>(Arrays.asList(parti));
        ArrayList<String> compList = new ArrayList<>(Arrays.asList(comp));

        partiList.sort(Comparator.naturalOrder());
        compList.sort(Comparator.naturalOrder());

        while (partiList.size() > 0 && compList.size() > 0 && partiList.get(0).equals(compList.get(0))) {
            partiList.remove(0);
            compList.remove(0);
        }

        while (partiList.size() > 0 && compList.size() > 0 && partiList.get(1).equals(compList.get(0))) {
            partiList.remove(1);
            compList.remove(0);
        }

        return partiList.get(0);
    }

    public static void main(String[] args) {
        String[] parti = {"김", "이", "박", "윤", "최", "홍"};
        String[] comp = {"김", "이", "윤", "최", "홍"};
        System.out.println(solution(parti, comp));
    }
}
