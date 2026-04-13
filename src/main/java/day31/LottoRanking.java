package day31;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Lv3 61. 로또의 최고 순위와 최저 순위
public class LottoRanking {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int[] win_nums = new int[]{31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(sol.solution(lottos, win_nums)));

        lottos = new int[] {0, 0, 0, 0, 0, 0};
        win_nums = new int[] {38, 19, 20, 40, 15, 25};
        System.out.println(Arrays.toString(sol.solution(lottos, win_nums)));

        lottos = new int[] {45, 4, 35, 20, 3, 9};
        win_nums = new int[] {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(sol.solution(lottos, win_nums)));
    }

    private static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[]{6, 6};

            int zeroCnt = 0;
            int cnt = 0;
            Set<Integer> winSet = new HashSet<>();

            for (int num : win_nums) {
                winSet.add(num);
            }

            for (int num : lottos) {
                if (num == 0) {
                    zeroCnt++;
                } else if (winSet.contains(num)) {
                    cnt++;
                }
            }

            if (zeroCnt + cnt > 0) {
                answer[0] = Math.max(7 - (zeroCnt + cnt), 1);
                if (cnt > 0) {
                    answer[1] = Math.max(7 - cnt, 1);
                }
            }

            return answer;
        }
    }
}
