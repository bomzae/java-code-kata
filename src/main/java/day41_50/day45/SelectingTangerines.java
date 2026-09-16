package day41_50.day45;

import java.util.Arrays;

// Lv2 연습문제. 귤 고르기
public class SelectingTangerines {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int k = 6;
        int[] tangerine = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(sol.solution(k, tangerine));

        k = 4;
        tangerine = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(sol.solution(k, tangerine));

        k = 2;
        tangerine = new int[]{1, 1, 1, 1, 2, 2, 2, 3};
        System.out.println(sol.solution(k, tangerine));
    }

    private static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            // 최소, 최대값 찾기
            int min = tangerine[0];
            int max = tangerine[0];

            for (int size : tangerine) {
                min = Math.min(min, size);
                max = Math.max(max, size);
            }

            // 빈도 수 확인
            int[] frequency = new int[max - min + 1];

            for (int size : tangerine) {
                frequency[size - min]++;
            }

            // 빈도 수 정렬
            Arrays.sort(frequency);

            // 한 상자에 몇 개가 들어가는지 확인하기
            int box = 0;

            for (int freq = frequency.length - 1; freq >= 0; freq--) {
                box += frequency[freq];
                answer++;

                if (box >= k) {
                    break;
                }
            }

            return answer;
        }
    }
}
