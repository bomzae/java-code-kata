package day41_50.day48;

import java.util.Arrays;

// Lv3 연습문제. 셔틀버스
public class ShuttleBus {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] timetable = new String[] { "08:00", "08:01", "08:02", "08:03" };
        System.out.println(sol.solution(1, 1, 5, timetable));

        timetable = new String[] { "09:10", "09:09", "08:00" };
        System.out.println(sol.solution(2, 10, 2, timetable));

        timetable = new String[] { "09:00", "09:00", "09:00", "09:00" };
        System.out.println(sol.solution(2, 1, 2, timetable));

        timetable = new String[] { "00:01", "00:01", "00:01", "00:01", "00:01" };
        System.out.println(sol.solution(1, 1, 5, timetable));

        timetable = new String[] { "23:59" };
        System.out.println(sol.solution(1, 1, 1, timetable));

        timetable = new String[] { "23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" };
        System.out.println(sol.solution(10, 60, 45, timetable));
    }

    private static class Solution {
        public String solution(int n, int t, int m, String[] timetable) {

            int answer = 0;
            int crew = timetable.length;
            int[] timeForMin = new int[crew];

            // timetable을 분 단위로 변환
            for (int i = 0; i < crew; i++) {
                String[] time = timetable[i].split(":");

                timeForMin[i] = Integer.parseInt(time[0]) * 60
                        + Integer.parseInt(time[1]);
            }

            // 변환한 timetable 정렬
            Arrays.sort(timeForMin);

            int shuttle = 9 * 60;
            int idx = 0;

            for (int i = 0; i < n; i++) {

                int cnt = 0;

                // 이번 셔틀의 탑승 인원 체크
                while (cnt < m && idx < crew) {

                    if (timeForMin[idx] <= shuttle) {
                        cnt++;
                        idx++;
                    } else {
                        break;
                    }
                }

                // 마지막 셔틀일 때
                if (i == n - 1) {

                    // 만약 셔틀이 다 찼다면
                    if (cnt == m) {
                        // 마지막 사람보다 1분 먼저 도착
                        answer = timeForMin[idx - 1] - 1;
                    } else {
                        answer = shuttle;
                    }
                }

                shuttle += t;
            }

            return String.format("%02d:%02d", answer / 60, answer % 60);
        }
    }
}
