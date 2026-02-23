package day7;

// Lv2 36. 문자열 다루기 기본
public class StringHandling {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("a234"));
        System.out.println(sol.solution("1234"));
    }

    private static class Solution {
        public boolean solution(String s) {
            boolean answer = true;

            int len = s.length();
            if ((len != 4) && (len != 6)) return false;

            for (int i = 0; i < len; i++) {
                if (s.charAt(i) > '9') return false;
            }

            return answer;
        }
    }
}
