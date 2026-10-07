package day51_60.day54;

// Lv3 연습문제. 입국심사
public class Immigration {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] times = new int[]{7, 10};
        System.out.println(sol.solution(6, times));
    }

    private static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;

            int maxTime = 0;
            for (int time : times) {
                maxTime = Math.max(maxTime, time);
            }

            long low = 1; // 가장 짧게 걸리는 시간
            long high = (long) n * maxTime; // 가장 오래 걸리는 시간

            while (low <= high) {
                long mid = low + (high - low) / 2;
                long complete = 0;

                for (int i = 0; i < times.length; i++) {
                    complete += mid / times[i];

                    if (complete >= n) {
                        break;
                    }
                }

                if (complete < n) { // 모든 사람이 시간 내에 검사를 받지 못하는 경우
                    low = mid + 1;
                } else { // 모든 사람이 시간 내에 검사를 받을 수 있는 경우
                    high = mid - 1;
                    answer = mid;
                }
            }

            return answer;
        }
    }
}
