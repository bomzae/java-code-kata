package day33;

// Lv3 63. 숫자 짝꿍
public class NumberPartner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("100", "2345"));
        System.out.println(sol.solution("100", "203045"));
        System.out.println(sol.solution("100", "123450"));
        System.out.println(sol.solution("12321", "42531"));
        System.out.println(sol.solution("5525", "1255"));
    }

    private static class Solution {
        public String solution(String X, String Y) {
            String answer = "";
            int[] xCnt = new int[10];
            int[] yCnt = new int[10];

            for (int i = 0; i < X.length(); i++) {
                xCnt[X.charAt(i) - '0']++;
            }

            for (int i = 0; i < Y.length(); i++) {
                yCnt[Y.charAt(i) - '0']++;
            }

            for (int i = 9; i >= 0; i--) {
                int min = Integer.min(xCnt[i], yCnt[i]);

                if (min > 0) {
                    answer += String.valueOf(i).repeat(min);
                }
            }

            if (answer.length() > 1 && answer.charAt(0) == '0') {
                return "0";
            }

            if (answer.isEmpty()) {
                return "-1";
            }

            return answer;
        }
    }
}
