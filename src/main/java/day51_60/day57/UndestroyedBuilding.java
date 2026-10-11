package day51_60.day57;

// Lv3 연습문제. 파괴되지 않은 건물
public class UndestroyedBuilding {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] board = new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        System.out.println(sol.solution(board, skill));

        board = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        skill = new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};
        System.out.println(sol.solution(board, skill));
    }

    private static class Solution {
        public int solution(int[][] board, int[][] skill) {
            int answer = 0;

            int rows = board.length;
            int cols = board[0].length;
            int[][] diff = new int[rows + 1][cols + 1];

            // 변화 시작점과 (종료 지점 + 1)의 네 꼭짓점에 변화량 저장
            for (int[] sk : skill) {
                int degree = sk[0] == 1 ? -1 * sk[5] : sk[5];

                diff[sk[1]][sk[2]] += degree;
                diff[sk[1]][sk[4] + 1] -= degree;
                diff[sk[3] + 1][sk[2]] -= degree;
                diff[sk[3] + 1][sk[4] + 1] += degree;
            }

            // 누적합 구하기
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i > 0) diff[i][j] += diff[i - 1][j];
                    if (j > 0) diff[i][j] += diff[i][j - 1];
                    if (i > 0 && j > 0) diff[i][j] -= diff[i - 1][j - 1];
                }
            }

            // 기존값 + 변화량이 0 이상인지 확인
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] + diff[i][j] > 0) {
                        answer++;
                    }
                }
            }

            return answer;
        }
    }
}
