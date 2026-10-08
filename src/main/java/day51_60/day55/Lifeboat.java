package day51_60.day55;

import java.util.Arrays;

// Lv2 연습문제. 구명보트
public class Lifeboat {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] people = new int[]{70, 50, 80, 50};
        System.out.println(sol.solution(people, 100));

        people = new int[]{70, 80, 50};
        System.out.println(sol.solution(people, 100));
    }

    private static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            int n = people.length;
            int start = 0;
            int end = n - 1;

            Arrays.sort(people);
            while (start <= end) {

                if (people[start] + people[end] > limit) {
                    end--;
                } else {
                    start++;
                    end--;
                }
                answer++;
            }

            return answer;
        }
    }
}
