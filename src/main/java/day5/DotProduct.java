package day5;

// Lv2 32. 내적
public class DotProduct {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1, 2, 3, 4}; int[] b = {-3, -1, 0, 2};
        System.out.println(sol.solution(a, b));
        a = new int[]{-1, 0, 1}; b = new int[]{1, 0, -1};
        System.out.println(sol.solution(a, b));
    }

    private static class Solution {
        public int solution(int[] a, int[] b) {
            int answer = 0;
            int n = a.length;

            for (int i = 0; i < n; i++) {
                answer += a[i] * b[i];
            }

            return answer;
        }
    }
}
