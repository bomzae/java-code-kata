package day1;

// Lv1 22. 두 정수 사이의 합
public class SumOfTheRange {
    public static void main(String[] args) {
        Solution sol = new Solution();

        long result = sol.solution(3, 5);
        System.out.println(result);

        result = sol.solution(3, 3);
        System.out.println(result);

        result = sol.solution(5, 3);
        System.out.println(result);
    }

    private static class Solution {
        public long solution(int a, int b) {
            long answer;
            if (a == b) return a;

            if (Math.max(a, b) == a) {
                answer = range(a, b);
            } else {
                answer = range(b, a);
            }

            return answer;
        }

        private long range(int a, int b) {
            long answer = 0;
            for (int i = b; i <= a; i++) {
                answer += i;
            }

            return answer;
        }
    }
}
