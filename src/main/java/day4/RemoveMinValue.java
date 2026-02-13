package day4;

import java.util.Arrays;

// Lv1 29. 제일 작은 수 제거하기
public class RemoveMinValue {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(sol.solution(arr)));

        arr = new int[]{10};
        System.out.println(Arrays.toString(sol.solution(arr)));
    }

    private static class Solution {
        public int[] solution(int[] arr) {
            if (arr.length <= 1) {
                return new int[]{-1};
            }

            int min = Arrays.stream(arr)
                    .min()
                    .getAsInt();

            int[] answer = Arrays.stream(arr)
                    .filter(n -> n != min)
                    .toArray();

            return answer;
        }
    }
}
