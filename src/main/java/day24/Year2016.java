package day24;

// Lv3 54. 2016년
public class Year2016 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, 24));;
    }

    private static class Solution {
        public String solution(int a, int b) {
            String[] day = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
            int[] month = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

            int idx = 5;

            for (int i = 0; i < a - 1; i++) {
                idx += month[i];
            }
            idx %= 7;

            idx = (idx + b - 1) % 7;

            return day[idx];
        }
    }
}
