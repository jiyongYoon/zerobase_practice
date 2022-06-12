package Structure;

class MyHashTable {
    Integer[] table; // value가 들어갈 배열
    int elementCnt; // value 개수
    int c; // 이중 해싱에 필요한 변수. 보통 c는 테이블 사이즈보다 조금 작은 소수

    MyHashTable() {}
    MyHashTable(int size) {
        this.table = new Integer[size];
        this.elementCnt = 0;
        this.c = this.getHashC(size); // 객체 생성 시 c값도 미리 구해놓음
    }

    // Hash값 구하는 메서드
    public int getHash(int key) { // 일반적인 방법이며, 구현에 따라 Hash값은 다르게 구할 수 있음
        return key % this.table.length;
    }
    // 이중해싱 시 Hash값 구하는 메서드
    public int getHash2(int key) {
        int hash = 1 + key % this.c;
        return hash;
    }
    // C값 구하는 메서드 (사이즈보다 작은 소수)
    public int getHashC(int size) {
        int c = 0;

        if(size <= 2) { // 사이즈가 2 이하면 1 또는 2면 충분
            return size;
        }

        for (int i = size - 1; i > 2; i--) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0) { // 루프 돌면서 나누어떨어지는 i값 찾기
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                c = i; // c에 할당
                break;
            }
        }
        return c;
    }
    // 키-값 입력
    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        // 해시테이블 기본 setValue (충돌상황 처리 안함)
        this.table[idx] = data;
        this.elementCnt++;


        // 선형 탐사법 - 다음 빈공간에 데이터 넣기
        /*
        if (this.elementCnt == this.table.length) {
            System.out.println("Full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else {
            int newIdx = idx; // 새로운 인덱스 변수
            while(true) {
                newIdx = (newIdx+1) % this.table.length; // newIdx 하나씩 키워가며
                if(this.table[newIdx] == null) { // 남는 공간 확인
                    break;
                }
            }
            this.table[newIdx] = data;
        }
        this.elementCnt++;
         */

        // 제곱 탐사법
        /*
        if (this.elementCnt == this.table.length) {
            System.out.println("Full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else {
            int newIdx = idx;
            int cnt = 0; // 충돌 난 횟수 카운트할 변수
            while(true) {
                newIdx = (newIdx + (int)Math.pow(2, cnt)) % this.table.length; // 2^cnt만큼을 새로운 인덱스에 더해줌
                if(this.table[newIdx] == null) {
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elementCnt++;
        */

        // 이중 해싱
        /*
        if (this.elementCnt == this.table.length) {
            System.out.println("Full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else {
            int newIdx = idx;
            int cnt = 1;
            while(true) {
                newIdx = (newIdx + this.getHash2(newIdx) * cnt) % this.table.length; // 해싱을 한번 더 해서 나온 해시값 활용
                if(this.table[newIdx] == null) {
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        elementCnt++;
        */
    }

    // 키를 통한 값 리턴
    public int getValue(int key) {
        int idx = this.getHash(key);
        return this.table[idx];
    }

    // 키-값 지우기
    public void removeValue(int key) {
        int idx = this.getHash(key);
        this.table[idx] = null;
        this.elementCnt--;
    }

    // 해시테이블 출력
    public void printHashTable() {
        for (int i = 0; i < this.table.length; i++) {
            System.out.println(i + ": " + this.table[i]);
        }
    }
}

public class HashTable {
}
