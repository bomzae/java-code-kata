package day34;

// Lv3 64. 체육복
public class gymClothes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
        System.out.println(sol.solution(5, new int[] {2, 4}, new int[] {3}));
        System.out.println(sol.solution(3, new int[] {3}, new int[] {1}));
    }

    private static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            boolean[] lostClothes = new boolean[n];
            boolean[] hasExtra = new boolean[n];

            for (int idx : lost) {
                lostClothes[idx - 1] = true;
            }

            for (int idx : reserve) {
                hasExtra[idx - 1] = true;
            }

            for (int i = 0; i < n; i++) {
                if (lostClothes[i] && hasExtra[i]) {
                    lostClothes[i] = false;
                    hasExtra[i] = false;
                }
            }

            for (int i = 0; i < n; i++) {
                if (!lostClothes[i]) {
                    continue;
                }

                if (i > 0 && hasExtra[i - 1]) {
                    lostClothes[i] = false;
                    hasExtra[i - 1] = false;
                } else if (i < n - 1 && hasExtra[i + 1]) {
                    lostClothes[i] = false;
                    hasExtra[i + 1] = false;
                }
            }

            for (boolean need : lostClothes) {
                if (!need) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
