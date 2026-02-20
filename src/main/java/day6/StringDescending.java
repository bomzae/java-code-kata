package day6;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Lv2 34. 문자열 내림차순으로 배치하기
public class StringDescending {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("Zbcdefg"));
    }

    private static class Solution {
        public String solution(String s) {
            String answer = Stream.of(s.split(""))
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.joining());

            return answer;
        }
    }
}
