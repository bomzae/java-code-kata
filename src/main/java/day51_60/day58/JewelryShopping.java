package day51_60.day58;

import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;

// Lv3 연습문제. 보석 쇼핑
public class JewelryShopping {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] gems = new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(sol.solution(gems)));

        gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
        System.out.println(Arrays.toString(sol.solution(gems)));

        gems = new String[]{"XYZ", "XYZ", "XYZ"};
        System.out.println(Arrays.toString(sol.solution(gems)));

        gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(Arrays.toString(sol.solution(gems)));
    }

    private static class Solution {
        public int[] solution(String[] gems) {
            int[] answer = {};

            // Set으로 전체 보석 종류 확인
            HashSet<String> set = new HashSet<>(Arrays.asList(gems));

            int left = 0;
            int right = 0;
            int len = gems.length;
            int minLen = 100000;

            // Map에 현재 구간 보석 저장
            HashMap<String, Integer> map = new HashMap<>();

            while (right < len) {

                // right 위치 보석 map에 추가 (이미 있다면 개수만 증가)
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

                // 현재 구간이 모든 보석 종류를 포함한다면
                while (map.size() == set.size()) {

                    // 현재 구간이 더 짧으면 answer 갱신
                    if (right - left < minLen) {
                        answer = new int[]{left + 1, right + 1};
                        minLen = right - left;
                    }

                    // left 위치 보석 제거 후 left 중가
                    map.put(gems[left], map.get(gems[left]) - 1);
                    if (map.get(gems[left]) == 0) {
                        map.remove(gems[left]);
                    }

                    left++;
                }

                // 현재 구간이 모든 보석 종류를 포함하지 않으면 right 증가
                right++;
            }

            return answer;
        }
    }
}
