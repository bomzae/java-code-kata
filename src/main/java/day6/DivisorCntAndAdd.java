package day6;

// Lv2 33. 약수의 개수와 덧셈
public class DivisorCntAndAdd {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(13, 17));
        System.out.println(sol.solution(24, 27));
    }

    private static class Solution {
        public int solution(int left, int right) {
            int answer = 0;

            for(int i = left; i <= right; i++) {
                answer += (divisor(i) % 2 == 0) ? i : i * -1;
            }

            return answer;
        }

        int divisor(int n) {
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                if (n % i == 0) cnt++;
            }

            return cnt;
        }
    }
}
