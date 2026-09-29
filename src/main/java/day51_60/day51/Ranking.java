package day51_60.day51;

// Lv3 연습문제. 순위
public class Ranking {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] results = new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(sol.solution(5, results));
    }

    private static class Solution {
        public int solution(int n, int[][] results) {

            int answer = 0;
            int[][] graph = new int[n + 1][n + 1];

            // 그래프 만들기
            for (int[] res : results) {
                graph[res[0]][res[1]] = 1;
            }

            // 도달 가능한 정점 수 세기
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {

                        // k: 중간을 거치는 정점
                        // i: 출발 정점
                        // j: 도착 정점
                        if (graph[i][k] == 1 && graph[k][j] == 1) {
                            graph[i][j] = 1;
                        }

                    }
                }
            }

            // 결과 카운트
            for (int i = 1; i <= n; i++) {
                int cnt = 0;

                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] == 1 || graph[j][i] == 1) {
                        cnt++;
                    }
                }

                if (cnt == n - 1) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
