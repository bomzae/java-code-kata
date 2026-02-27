package day10;

// Lv2 40. 3진법 뒤집기
public class ReverseBase3 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(45));
        System.out.println(sol.solution(125));
    }

    private static class Solution {
        public int solution(int n) {
            return Integer.parseInt(convertBase3(n), 3);
        }

        private String convertBase3(int n) {
            if (n == 0) return "";
            return (n % 3) + convertBase3(n / 3);
        }
    }
}
