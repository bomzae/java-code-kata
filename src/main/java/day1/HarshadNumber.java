package day1;

// Lv1 21. 하샤드 수
public class HarshadNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();

        boolean result = sol.solution(10);
        System.out.println(result);

        result = sol.solution(11);
        System.out.println(result);

        result = sol.solution(12);
        System.out.println(result);

        result = sol.solution(13);
        System.out.println(result);
    }

    private static class Solution {
        public boolean solution(int x) {
            boolean answer = true;
            int num = sum(x);
            if (x % num != 0) answer = false;

            return answer;
        }

        private int sum(int num) {
            if (num < 10) {
                return num;
            }

            return (num % 10) + sum(num / 10);
        }
    }
}
