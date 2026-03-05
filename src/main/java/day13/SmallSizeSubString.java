package day13;

// Lv3 43. 크기가 작은 부분
public class SmallSizeSubString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("3141592", "271"));
        System.out.println(sol.solution("500220839878", "7"));
        System.out.println(sol.solution("10203", "15"));
    }

    private static class Solution {
        public int solution(String t, String p) {
            int answer = 0;
            int longLen = t.length();
            int shortLen = p.length();
            long shortNum = Long.parseLong(p);
            String str = "";

            for (int i = 0; i < (longLen - shortLen + 1); i++) {
                str = t.substring(i, i + shortLen);

                if (Long.parseLong(str) <= shortNum) answer++;
            }

            return answer;
        }
    }
}
