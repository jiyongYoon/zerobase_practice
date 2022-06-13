package Practice;

import com.sun.source.tree.Tree;
import java.util.*;

public class Practice024 {
//    과제7) 로또 당첨 프로그램
//    1~45 중 6개 맞추면 당첨.
//    구매수량을 입력받으면 당첨번호를 생성하여 당첨유무 판단을 하는 프로그램.
//    1) 구매수량 입력받기
//    2) 입력한 개수만큼 로또 개수 생성
//    3) 당첨 번호 생성
//    4) 당첨 번호와 구매로또 비교하여 숫자 일치여부 판단

    static void lottery() {
        //로또추첨
        Random random = new Random();
        TreeSet<Integer> luckLotSet = new TreeSet<>(); // 로또 당첨번호
        while(luckLotSet.size()<6) {
            luckLotSet.add(random.nextInt(1,46));
        }

        System.out.printf("[로또 당첨 프로그램]\n\n");
        //로또구매
        Scanner sc = new Scanner(System.in);
        System.out.print("로또 개수를 입력해 주세요. (숫자 1 ~ 10): ");
        int myLot = sc.nextInt(); // 로또 산 개수
        String rightCount=""; // 내가 살때마다 맞은 개수 체크하기
        TreeSet<Integer> myLotSet = new TreeSet<>(); // 로또 번호 1세트
        ArrayList<Integer> saveLotArr = new ArrayList<>(); // 다시 출력할 때 사용할 리스트
        for (int i = 1; i <= myLot; i++) {
            //로또 1개씩 뽑기
            while(myLotSet.size()<6) {
                myLotSet.add(random.nextInt(1,46));
            }
            HashSet<Integer> intersection = new HashSet<>(luckLotSet);  // luckLotset으로 intersection 생성
            intersection.retainAll(myLotSet);
            if(intersection.size()==0) {
                rightCount += 0;
            } else {
                rightCount += Integer.toString(intersection.size());
            }
            //로또 뽑은거 보여주기
            System.out.print(((char)(i+64)));
            ArrayList<Integer> myLotArr = new ArrayList<>(myLotSet);
            for (int j = 0; j < myLotArr.size(); j++) {
                saveLotArr.add(myLotArr.get(j));
                System.out.printf("\t%02d", myLotArr.get(j));
            }
            System.out.println();
            myLotSet.clear();
        }
        System.out.println();

        //추첨결과 발표 및 내 로또 결과
        System.out.println("[로또 발표]");
        ArrayList<Integer> luckLotArr = new ArrayList<>(luckLotSet);
        for (int j = 0; j < luckLotArr.size(); j++) {
            System.out.printf("\t%02d", luckLotArr.get(j));
        }
        System.out.print("\n\n");
        System.out.println("[내 로또 결과]");
        for (int i = 1; i <= myLot; i++) {
            System.out.print(((char)(i+64)));
            int k = 6*(i-1);
            for (int j = 1+k; j <= 6*i; j++) {
                System.out.printf("\t%02d",saveLotArr.get(j-1));
            }
            System.out.printf(" => %s개 일치\n", rightCount.charAt(i-1));
        }
    }

    public static void main(String[] args) {
        lottery();
    }
}

/*
[학습내용]
1) TreeSet은 집합 중 오름차순 정렬이 되는 데이터 형태 (LinkedHashSet은 입력한 순서대로)
2) 집합끼리 연산 가능
   1. 교집합: 비교할집합1.retainAll(비교할집합2);
      이렇게 하면 비교할집합1이 교집합으로 바뀌어버림. 아래와 같이 인스턴스 필요.
   ex) HashSet<Integer> intersection = new HashSet<>(luckLotSet);
       intersection.retainAll(myLotSet);
   2. 합집합: 합할집합1.addAll(합할집합2); *합할집합1에 들어감.
   3. 차집합: 원집합.removeAll(뺄집합); *원집합에서 뺄집합 원소들이 사라짐.
3) 집합 데이터 형태는 핸들링이 어려움. 리스트로 바꾸기 가능.
   ArrayList<Integer> 리스트객체명 = new ArrayList<>(집합객체명);

 */