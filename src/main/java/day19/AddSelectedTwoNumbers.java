package day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Lv3 49. 두 개 뽑아서 더하기
public class AddSelectedTwoNumbers {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{5, 0, 2, 7})));
    }

    private static class Solution {
        public int[] solution(int[] numbers) {
            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < (numbers.length - 1); i++) {
                for (int j = 1; j < (numbers.length - i); j++) {
                    int number = numbers[i] + numbers[i + j];
                    if(!answer.contains(number)) {
                        answer.add(number);
                    }
                }
            }

            Collections.sort(answer);

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
