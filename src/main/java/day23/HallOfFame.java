package day23;

import java.util.*;

// Lv3 53. 명예의 전당 (1)
public class HallOfFame {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(3, new int[] {10, 100, 20, 150, 1, 100, 200})));
        System.out.println(Arrays.toString(sol.solution(4, new int[] {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }

    private static class Solution {
        public int[] solution(int k, int[] score) {
            List<Integer> answer = new ArrayList<>();
            int[] rank = new int[k + 1];

            for (int i = 0; i < score.length; i++) {
                rank[0] = score[i];
                Arrays.sort(rank);
                answer.add((i < k) ? rank[k - i] : rank[1]);
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}