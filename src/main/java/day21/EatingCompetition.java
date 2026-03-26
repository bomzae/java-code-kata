package day21;

// Lv3 51. 푸드 파이트 대회
public class EatingCompetition {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1, 3, 4, 6}));
        System.out.println(sol.solution(new int[] {1, 7, 1, 2}));
    }

    private static class Solution {
        public String solution(int[] food) {
            String answer = "";
            StringBuilder half = new StringBuilder();

            for (int i = 0; i < food.length; i++) {
                if (food[i] >= 2) {
                    half.append((i + "").repeat(food[i] / 2));
                }
            }

            answer += half + "0";
            answer += half.reverse();

            return answer;
        }
    }
}
