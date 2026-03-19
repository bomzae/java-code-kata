package day17;

import java.util.Arrays;
import java.util.Comparator;

// Lv3 47. 문자열 내 마음대로 정렬하기
public class CustomSortString {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(sol.solution(new String[]{"abce", "abcd", "cdx"}, 2)));

    }

    private static class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, Comparator.comparingInt((String s) -> s.charAt(n)).thenComparing(s -> s));

            return strings;
        }
    }
}
