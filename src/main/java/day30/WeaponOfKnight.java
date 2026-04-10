package day30;

// Lv3 60. 기사단원의 무기
public class WeaponOfKnight {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, 3, 2));
        System.out.println(sol.solution(10, 3, 2));
    }

    private static class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 1;

            int cnt = 0;
            for (int i = 2; i <= number; i++) {
                cnt = countDivisors(i);
                answer += (cnt > limit) ? power : cnt;
            }

            return answer;
        }

        private int countDivisors(int num) {
            int cnt = 2;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    if (i == num / i) {
                        cnt += 1;
                    } else {
                        cnt += 2;
                    }
                }
            }

            return cnt;
        }
    }
}
