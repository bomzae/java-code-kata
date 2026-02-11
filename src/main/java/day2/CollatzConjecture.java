package day2;

// Lv1 23. 콜라츠 추측
public class CollatzConjecture {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(6));
        System.out.println(sol.solution(16));
        System.out.println(sol.solution(626331));
    }

    private static class Solution {
        public int solution(long num) {
            int answer = 0;

            while (num > 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = num * 3 + 1;
                }

                answer++;
                if (answer > 500) {
                    answer = -1;
                    break;
                }
            }

            return answer;
        }
    }
}
