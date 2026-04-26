package day44;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

// Lv4 74. 신고 결과 받기
public class ReportResult {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] id_list = new String[] {"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        System.out.println(Arrays.toString(sol.solution(id_list, report, 2)));

        id_list = new String[] {"con", "ryan"};
        report = new String[] {"ryan con", "ryan con", "ryan con", "ryan con"};
        System.out.println(Arrays.toString(sol.solution(id_list, report, 3)));
    }

    private static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int n = id_list.length;
            int[] answer = new int[n];
            int[] reportCount = new int[n];
            boolean[][] reportUser = new boolean[n][n];

            Map<String, Integer> idMap = new HashMap<>();
            for (int i = 0; i < id_list.length; i++) {
                idMap.put(id_list[i], i);
            }

            for (String r : report) {
                String[] user = r.split(" ");

                int reporter = idMap.get(user[0]);
                int reported = idMap.get(user[1]);

                if (reportUser[reporter][reported] == true) {
                    continue;
                }

                reportCount[reported]++;
                reportUser[reporter][reported] = true;
            }

            for (int i = 0; i < id_list.length; i++) {
                if (reportCount[i] < k) {
                    continue;
                }

                for (int j = 0; j < id_list.length; j++) {
                    if (reportUser[j][i]) {
                        answer[j]++;
                    }
                }
            }

            return answer;
        }
    }
}
