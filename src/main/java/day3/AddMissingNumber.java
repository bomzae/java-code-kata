package day3;

// Lv1 28. 없는 숫자 더하기
public class AddMissingNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(sol.solution(numbers));

        numbers = new int[]{5, 8, 4, 0, 6, 7, 9};
        System.out.println(sol.solution(numbers));
    }

    private static class Solution {
        public int solution(int[] numbers) {
            int answer = 45;

            for (int i : numbers) {
                answer -= i;
            }

            return answer;
        }
    }
}
