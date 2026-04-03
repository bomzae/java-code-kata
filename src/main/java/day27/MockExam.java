package day27;

import java.util.Arrays;
import java.util.stream.IntStream;

// Lv3 57. 모의고사
public class MockExam {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 3, 2, 4, 2})));
    }

    private static class Solution {
        public int[] solution(int[] answers) {
            int[] cnt = new int[3];
            int[] num1 = new int[] { 1, 2, 3, 4, 5 };
            int[] num2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
            int[] num3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

            for (int i = 0; i < answers.length; i++) {
                if(answers[i] == num1[i % num1.length]) cnt[0]++;
                if(answers[i] == num2[i % num2.length]) cnt[1]++;
                if(answers[i] == num3[i % num3.length]) cnt[2]++;
            }

            int max = Arrays.stream(cnt).max().getAsInt();

            return IntStream.range(0, 3)
                    .filter(n -> cnt[n] == max)
                    .map(n -> n + 1)
                    .toArray();
        }
    }
}
