package Structure;

import java.util.PriorityQueue;

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 인터페이스 메서드 오버라이드 부분
    @Override
    public int compareTo(Person o) {
        // 1 리턴 - 위치변경 안함
        // -1 리턴 - 위치변경 함

        // 새롭게 추가한 데이터(this.age)가
        // 기존 데이터(o.age)보다 더 적을때 1 리턴 -> 오름차순
        return this.age >= o.age ? 1 : -1;

        // 내림차순이라면 리턴 값을 반대로
        //return this.age >= o.age ? -1 : 1;
    }
}

public class MyPriorityQueue {
    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person> pq = new PriorityQueue<>();

        for (int i = 0; i < name.length; i++) {
            pq.offer(new Person(name[i], age[i]));
        }

        System.out.println("== 실제 출력 순서 ==");
        while(!pq.isEmpty()) {
            Person p = pq.poll();
            System.out.println(p.name + "-" + p.age);
        }

    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

        // 인터페이스 사용하지 않는 경우
        /*
        // 객체를 만들 때 어떤 값을 비교할지 인자로 넣어주어서 사용도 가능
        PriorityQueue<Person> pq = new PriorityQueue<>(
                (Person p1, Person p2) -> p1.age >= p2.age ? 1 : -1);

        for (int i = 0; i < name.length; i++) {
            pq.offer(new Person(name[i], age[i]));
        }

        while(!pq.isEmpty()) {
            Person p = pq.poll();
            System.out.println(p.name + "-" + p.age);
        }
         */

        // 나이순이 아니라 문자열로 정렬을 하는 경우
        /*
        PriorityQueue<Person> pq = new PriorityQueue<>(
                (Person p1, Person p2) -> p1.name.compareTo(p2.name));

        for (int i = 0; i < name.length; i++) {
            pq.offer(new Person(name[i], age[i]));
        }

        while(!pq.isEmpty()) {
            Person p = pq.poll();
            System.out.println(p.name + "-" + p.age);
        }
         */

        /*
        [A.compareTo(B) 메서드]
        A를 B와 비교했을 때
        - 같다: return 0
        - A가 작다: return 0보다 작은 값
        - B가 작다: return 0보다 큰 값
        **참고: https://mine-it-record.tistory.com/133**
         */
    }
}