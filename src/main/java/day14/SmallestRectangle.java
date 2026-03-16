package day14;

// Lv3 44. 최소직사각형
public class SmallestRectangle {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(sol.solution(sizes));

        sizes = new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(sol.solution(sizes));

        sizes = new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(sol.solution(sizes));
    }

    private static class Solution {
        public int solution(int[][] sizes) {
            int width = 0, height = 0;
            int small = 0, large = 0;

            for (int[] size : sizes) {
                small = Math.min(size[0], size[1]);
                large = Math.max(size[0], size[1]);

                if (width < small) width = small;
                if (height < large) height = large;
            }

            return width * height;
        }
    }
}
