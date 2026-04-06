package day28;

// Lv3 58. 소수 만들기
public class MakePrime {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1,2,3,4}));
        System.out.println(sol.solution(new int[]{1,2,7,6,4}));
    }

    private static class Solution {
        public int solution(int[] nums) {
            int cnt = 0;

            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (isPrime(nums[i] + nums[j] + nums[k])) {
                            cnt++;
                        }
                    }
                }
            }

            return cnt;
        }

        private boolean isPrime(int num) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
