package day12;

// Lv3 42. 삼총사
public class ThreeMusketeers {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(sol.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(sol.solution(new int[]{-1, 1, -1, 1}));
    }

    private static class Solution {
        public int solution(int[] number) {
            int answer = 0;

            answer = combination(number, 0, 3, 0);

            return answer;
        }

        private int combination(int[] number, int start, int remain, int sum) {
            if (remain == 0) {
                return sum == 0 ? 1 : 0;
            }

            int cnt = 0;
            for (int i = start; i < number.length; i++) {
                cnt += combination(number, i + 1, remain - 1, sum + number[i]);
            }

            return cnt;
        }
    }
}
