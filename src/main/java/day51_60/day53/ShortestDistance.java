package day51_60.day53;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(sol.solution(maps));

        maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(sol.solution(maps));
    }

    private static class Solution {

        public int solution(int[][] maps) {
            int rowSize = maps.length;
            int colSize = maps[0].length;

            // 방문 처리에 사용할 배열
            boolean[][] visited = new boolean[rowSize][colSize];

            return bfs(maps, visited);
        }

        private int bfs(int[][] maps, boolean[][] visited) {
            Queue<int[]> queue = new LinkedList<>();

            // 상, 하, 좌, 우 이동에 따른 행과 열의 변화량
            int[] dRow = {-1, 1, 0, 0};
            int[] dCol = {0, 0, -1, 1};

            // 시작 위치: 행, 열, 지나온 칸의 수
            queue.offer(new int[]{0, 0, 1});
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                int distance = current[2];

                // 상대 팀 진영에 도착한 경우
                if (row == maps.length - 1 && col == maps[0].length - 1) {
                    return distance;
                }

                // 현재 위치에서 상하좌우 칸 확인
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + dRow[i];
                    int nextCol = col + dCol[i];

                    // 맵 범위를 벗어난 경우
                    if (nextRow < 0 || nextRow >= maps.length
                            || nextCol < 0 || nextCol >= maps[0].length) {
                        continue;
                    }

                    // 벽이거나 이미 방문한 경우
                    if (maps[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                        continue;
                    }

                    // 방문 처리 후 큐에 삽입
                    visited[nextRow][nextCol] = true;

                    queue.offer(new int[]{nextRow, nextCol, distance + 1});
                }
            }

            // 상대 팀 진영에 도착할 수 없는 경우
            return -1;
        }
    }
}
