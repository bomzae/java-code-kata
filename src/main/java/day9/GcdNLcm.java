package day9;

import java.util.Arrays;

// Lv2 39. 최대공약수와 최소공배수
public class GcdNLcm {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(3, 12)));
        System.out.println(Arrays.toString(sol.solution(2, 5)));
    }

    private static class Solution {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];
            answer[0] = (n > m) ? Gcd(n, m) : Gcd(m, n);
            answer[1] = (n * m) / answer[0];

            return answer;
        }

        private int Gcd(int a, int b) {
            for (int i = b; i > 1; i--) {
                if ((a % i == 0) && (b % i == 0)) return i;
            }
            return 1;
        }
    }
}
