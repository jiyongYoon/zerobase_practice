package Practice;

import java.util.ArrayList;

class List {
    String genresName;
    int playsCnt;
    int idx;
    List() {}
    public List(String genresName, int playsCnt, int idx) {
        this.genresName = genresName;
        this.playsCnt = playsCnt;
        this.idx = idx;
    }
}

public class Practice058 {
    public static int solution(String[] g, int[] p) {
        int answer = 0;

        ArrayList<String> genreslist = new ArrayList<>();
        ArrayList<List> list = new ArrayList<>();
        // 후보리스트에 자료 다 넣기
        for (int i = 0; i < p.length; i++) {
            list.add(new List(g[i],p[i],i));
            if(!genreslist.contains(g[i])) {
                genreslist.add(g[i]);
            }
        }
        // 장르 별 재생수 배열 만들기
        int[] playsSum = new int[genreslist.size()];
        // 장르 별 재생 수 넣기
        for (int i = 0; i < genreslist.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                List curlist = list.get(j);
                if(genreslist.get(i) == curlist.genresName) {
                    playsSum[i] += curlist.playsCnt;
                }
            }
        }
        // 재생 수 가장 많은 장르부터 나열
        String[] ordergenres = new String[genreslist.size()];
//        for (int i = 0; i < ordergenres.length; i++) {
//            ordergenres[i] =
//        }


        return answer;



    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150,  800, 2500}));
    }
}
