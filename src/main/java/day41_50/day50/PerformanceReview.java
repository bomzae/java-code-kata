package day41_50.day50;

import java.util.Arrays;

// Lv3 연습문제. 인사고과
public class PerformanceReview {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
    }

    private static class Solution {
        public int solution(int[][] scores) {
            int answer = 0;

            // 완호 점수 저장
            int attitudeScore = scores[0][0];
            int peerScore = scores[0][1];

            // 근무 태도는 내림차순, 동료 평가는 오름차순으로 점수 정렬
            Arrays.sort(scores, (a, b) ->
                    a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));

            // 완호 점수보다 높은 사람 수 세기
            int maxPeerScore = 0;
            for (int i = 0; i < scores.length; i++) {

                // 동료 평가가 현재 최대 동료 평가보다 낮다면
                if (scores[i][1] < maxPeerScore) {

                    // 완호라면 -1 반환
                    if (scores[i][0] == attitudeScore && scores[i][1] == peerScore) {
                        return -1;
                    }

                    // 카운트 안 하고 넘기기
                    continue;
                }

                // 완호보다 점수가 높다면 카운트
                if (scores[i][0] + scores[i][1] > attitudeScore + peerScore) {
                    answer++;
                }

                // 현재 탐색의 동료평가 중 가장 높은 값으로 갱신
                if (scores[i][1] > maxPeerScore) {
                    maxPeerScore = scores[i][1];
                }
            }

            return answer + 1;
        }
    }
}
