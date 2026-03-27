package day22;

// Lv3 52. 콜라 문제
public class ColaProblem {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2, 1, 20));
        System.out.println(sol.solution(3, 1, 20));
    }

    private static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;

            while (n >= a) {
                answer += n / a * b;
                n = (n / a * b) + (n % a);
            }

            return answer;
        }
    }
}
