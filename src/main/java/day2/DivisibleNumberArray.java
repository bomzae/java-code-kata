package day2;

import java.util.Arrays;

public class DivisibleNumberArray {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {5, 9, 7, 10};
        System.out.println(Arrays.toString(sol.solution(arr, 5)));
        arr = new int[]{2, 36, 1, 3};
        System.out.println(Arrays.toString(sol.solution(arr, 1)));
        arr = new int[]{3, 2, 6};
        System.out.println(Arrays.toString(sol.solution(arr, 10)));
    }

    private static class Solution {
        public int[] solution(int[] arr, int divisor) {
            int len = arr.length;
            int[] answer = new int[len];
            int idx = 0;

            for (int i = 0; i < len; i++) {
                if (arr[i] % divisor == 0) {
                    answer[idx++] = arr[i];
                }
            }

            if (idx == 0) answer[0] = -1;
            else Arrays.sort(answer);
            answer = Arrays.stream(answer).filter(num -> num != 0).toArray();

            return answer;
        }
    }
}
