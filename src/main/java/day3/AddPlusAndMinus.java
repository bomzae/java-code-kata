package day3;

// Lv1 25. 음양 더하기
public class AddPlusAndMinus {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
        System.out.println(sol.solution(absolutes, signs));

        absolutes = new int[]{1, 2, 3};
        signs = new boolean[]{false, false, true};
        System.out.println(sol.solution(absolutes, signs));
    }

    private static class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            int len = absolutes.length;
            for (int i = 0; i < len; i++) {
                answer += absolutes[i] * ((signs[i]) ? 1 : -1);
            }

            return answer;
        }
    }
}
