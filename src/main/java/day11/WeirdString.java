package day11;

// Lv3 41. 이상한 문자 만들기
public class WeirdString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("try hello world"));
    }

    private static class Solution {
        public String solution(String s) {
            String answer = "";

            int idx = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    answer += " ";
                    idx = 0;
                    continue;
                }

                if (idx % 2 == 0) {
                    answer += Character.toUpperCase(s.charAt(i));
                }
                else {
                    answer += Character.toLowerCase(s.charAt(i));
                }
                idx += 1;
            }

            return answer;
        }
    }
}
