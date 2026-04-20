package day38;

// Lv4 68. 햄버거 만들기
public class Hamburger {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(sol.solution(new int[] {1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }

    private static class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;
            int[] stack = new int[ingredient.length];
            int top = 0;

            for (int n : ingredient) {
                stack[top++] = n;

                if (top >= 4) {
                    if (stack[top - 4] == 1 && stack[top - 3] == 2
                            && stack[top - 2] == 3 && stack[top - 1] == 1) {
                        top -= 4;
                        answer++;
                    }
                }
            }

            return answer;
        }
    }
}
