package day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Lv3 50. 가장 가까운 같은 글자
public class NearestWord {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution("banana")));
        System.out.println(Arrays.toString(sol.solution("foobar")));
    }

    private static class Solution {
        public int[] solution(String s) {
            List<Integer> answer = new ArrayList<>();

            boolean[] flag = new boolean[26];
            int[] distance = new int[26];

            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 97;

                if(flag[idx]) {
                    answer.add(i - distance[idx]);
                } else {
                    answer.add(-1);
                    flag[idx] = true;
                }
                distance[idx] = i;
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
