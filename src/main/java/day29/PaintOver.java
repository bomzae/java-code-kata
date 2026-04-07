package day29;

// Lv3 59. 덧칠하기
public class PaintOver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8, 4, new int[] {2, 3, 6}));
        System.out.println(sol.solution(5, 4, new int[] {1, 3}));
        System.out.println(sol.solution(4, 1, new int[] {1, 2, 3, 4}));
    }

    private static class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 1;

            int cursor = section[0] + m;
            for (int i = 1; i < section.length; i++) {
                if (section[i] < cursor) {
                    continue;
                }

                cursor = section[i] + m;
                answer++;
            }

            return answer;
        }
    }
}
