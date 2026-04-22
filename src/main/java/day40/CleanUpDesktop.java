package day40;

import java.util.Arrays;

// Lv4 70. 바탕화면 정리
public class CleanUpDesktop {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{".#...", "..#..", "...#."})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
        System.out.println(Arrays.toString(sol.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"..", "#."})));
    }

    private static class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];
            answer[0] = wallpaper.length;
            answer[1] = wallpaper[0].length();

            for (int i = 0; i < wallpaper.length; i++) {
                for (int j = 0; j < wallpaper[0].length(); j++) {
                    if (wallpaper[i].charAt(j) == '.') {
                        continue;
                    }

                    answer[0] = Math.min(i, answer[0]);
                    answer[1] = Math.min(j, answer[1]);
                    answer[2] = Math.max(i + 1, answer[2]);
                    answer[3] = Math.max(j + 1, answer[3]);
                }
            }

            return answer;
        }
    }
}
