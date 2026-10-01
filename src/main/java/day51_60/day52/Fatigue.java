package day51_60.day52;

// Lv2 연습문제. 피로도
public class Fatigue {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] dungeons = new int[][]{{80, 20}, {50, 40}, {30, 10}};
        System.out.println(sol.solution(80, dungeons));
    }

    private static class Solution {
        // 최대 던전 카운트를 저장할 변수
        private int answer = 0;
        private boolean[] visited;
        private int[][] dungeons;

        public int solution(int k, int[][] dungeons) {
            this.dungeons = dungeons;
            // 방문처리에 사용할 배열
            this.visited = new boolean[dungeons.length];

            dfs(k, 0);

            return answer;
        }

        void dfs(int currentFatigue, int cnt) {
            // 현재 경로에서 방문한 던전 수의 최댓값 저장
            answer = Math.max(answer, cnt);

            // 다음에 방문할 수 있는 모든 던전 탐색
            for (int i = 0; i < dungeons.length; i++) {
                int requiredFatigue = dungeons[i][0]; // 최소 필요도
                int consumedFatigue = dungeons[i][1]; // 소모 피로도

                // 방문하지 않았고, 현재 피로도가 최소 필요 피로도 이상인 경우
                if (!visited[i] && currentFatigue >= requiredFatigue) {
                    visited[i] = true;
                    dfs(currentFatigue - consumedFatigue, cnt + 1);

                    // 다른 던전 방문 순서를 확인하기 위해 방문 취소
                    visited[i] = false;
                }
            }
        }
    }
}
