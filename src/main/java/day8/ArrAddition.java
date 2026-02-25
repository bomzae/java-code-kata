package day8;

import java.util.Arrays;

// Lv2 37. 행렬의 덧셈
public class ArrAddition {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {5, 6}};
        System.out.println(Arrays.deepToString(sol.solution(arr1, arr2)));

        arr1 = new int[][]{{1}, {2}};
        arr2 = new int[][]{{3}, {4}};
        System.out.println(Arrays.deepToString(sol.solution(arr1, arr2)));
    }

    private static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int row = arr1.length;
            int col = arr1[0].length;
            int[][] answer = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    answer[i][j] = arr1[i][j] + arr2[i][j];
                }
            }

            return answer;
        }
    }
}
