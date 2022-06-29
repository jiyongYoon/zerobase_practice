// Leetcode 28
// https://leetcode.com/problems/implement-strstr/

public class Practice088 {
    public static int solution(String needle, String haystack) {
        if(needle.length() > haystack.length()) {
            return -1;
        } else if(needle.length() == haystack.length()) {
            if(needle.equals(haystack)) {
                return 0;
            } else {
                return -1;
            }
        }

        int left = 0;
        int right = needle.length() - 1;
        String tmp = "";

        while(right < haystack.length()) {
            tmp = haystack.substring(left, right + 1);
            if(needle.equals(tmp)) {
                return left;
            }
            left++;
            right++;
        }
        return -1;
    }

    public static int solution2(String needle, String haystack) {
        if(needle.length() > haystack.length()) {
            return -1;
        } else if(needle.length() == haystack.length()) {
            if(needle.equals(haystack)) {
                return 0;
            } else {
                return -1;
            }
        }

        int left = 0;
        int right = needle.length() - 1;
        StringBuffer sb = new StringBuffer();
        sb.append(haystack.substring(left, right + 1));

        while(right < haystack.length()) {
            // 형변환 이슈!!!
            if((sb.toString()).equals(needle)) {
                return left;
            }
            sb.delete(0, 1);
            left++;
            right++;
            if(right < haystack.length()) {
                sb.append(haystack.charAt(right));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String needle = "ll";
        String hayStack = "hello";

        System.out.println(solution(needle, hayStack));
        System.out.println(solution2(needle, hayStack));
    }
}

/*
[학습내용]
StringBuffer랑 String이랑 비교하려면 형변환을 해야한다!!
 */
