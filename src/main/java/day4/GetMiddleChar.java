package day4;

// Lv1 30. 가운데 글자 가져오기
public class GetMiddleChar {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("abcde"));
        System.out.println(sol.solution("qwer"));
    }

    private static class Solution {
        public String solution(String s) {
            String answer = "";
            int len = s.length();
            int idx = len / 2;

            if (len % 2 == 0) {
                answer = s.substring(idx - 1, idx + 1);
            } else {
                answer = s.substring(idx, idx + 1);
            }

            return answer;
        }
    }
}
