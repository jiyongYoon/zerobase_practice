public class Practice010 {
//    Q10. N명의 아이들, 규칙에 따라 사탕을 나누어줌.
//    1) 적어도 1개 이상의 사탕을 나누어줘야 한다.
//    2) 점수가 높은 아이에게는 바로 옆의 아이보다 사탕을 많이 줘야한다.
//    n명의 아이들에 대한 점수 표가 ratings 배열에 주어질 때, 나눠줘야 할 최소한의 사탕의 개수는?
//    <입출력 예시>
//    1, 2, 3 => 6 / 3, 2, 1 => 6 / 1, 0, 2 => 5 / 1, 2, 2 => 4
//    1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0 => 29

    public static void main(String[] args) {
        int[] ratings = {1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0};
        int[] candy = new int[ratings.length];
        int index = 0;
        int sum = 0;

        // 시작은 무조건 1개 주고 시작. (초기화를 이렇게 해도 될듯)
        candy[index] = 1;
        index++;
        
        while(index<ratings.length) { // 인덱스가 끝까지 갈때까지 비교 반복
            // 전이랑 비교해서 크면 더 줌.
            while(ratings[index-1]<ratings[index]) {
                candy[index] = candy[index-1]+1;
                // 인덱스 올리는 조건은 불변.
                if(index<ratings.length-1) {index++;}
                else {break;}
            }
            // 전이랑 같으면 1개만 줘도 됨.
            while(ratings[index-1]==ratings[index]) {
                candy[index] = 1;
                // 인덱스 올리는 조건은 불변.
                if(index<ratings.length-1) {index++;}
                else {break;}
            }
            // 그 전이 크면 지금에는 1개 주고 그 전은 더 클때까지 1씩 더해줌 반복.
            while(ratings[index-1]>ratings[index]) {
                candy[index] = 1;
                for (int i = 1; index-i>=0; i++) {
                    //그 전 아이 점수가 크고, 사탕 개수가 적을 때 사탕 더해줌.
                    if (ratings[index-i]>ratings[index-i+1]&&candy[index-i]<=candy[index-i+1]) {
                        candy[index-i]++;
                    }
                }
                // 인덱스 올리는 조건은 불변.
                if(index<ratings.length-1) {index++;}
                else {break;}
            }
            if(candy[index]>0) {
                break;
            }
        }
        // 사탕개수를 더해서 출력
        for (int i : candy) {
            sum += i;
        }
        System.out.println(sum);
        for (int i = 0; i < candy.length; i++) {
            System.out.print(candy[i] + " ");
        }
    }
}
/*
        [학습내용]
        *디버거를 두려워하지 말자. 오류를 찾아낼 수 있는 가장 손쉬운 방법이다*
 */
