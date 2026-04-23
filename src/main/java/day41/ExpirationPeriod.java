package day41;

import java.util.*;

// Lv4 71. 개인정보 수집 유효기간
public class ExpirationPeriod {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] terms = new String[] {"A 6", "B 12", "C 3"};
        String[] privacies = new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(sol.solution("2022.05.19", terms, privacies)));

        terms = new String[] {"Z 3", "D 5"};
        privacies = new String[] {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(Arrays.toString(sol.solution("2020.01.01", terms, privacies)));
    }

    private static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            Map<String, Integer> termMap = new HashMap<>();

            for (String term : terms) {
                String[] part = term.split(" ");
                termMap.put(part[0], Integer.parseInt(part[1]));
            }

            int totalDays = converter(today);

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < privacies.length; i++) {
                String[] part = privacies[i].split(" ");

                if (totalDays >= converter(part[0]) + (termMap.get(part[1]) * 28)) {
                    result.add(i + 1);
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private int converter(String date) {
            String[] part = date.split("\\.");
            int year = Integer.parseInt(part[0]);
            int month = Integer.parseInt(part[1]);
            int day = Integer.parseInt(part[2]);
            return year * 12 * 28 + month * 28 + day;
        }
    }
}
