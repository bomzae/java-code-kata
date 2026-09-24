package day41_50.day49;

// Lv3 연습문제. 풍선 터트리기
public class PopBalloon {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[] { 9, -1, -5 }));
        System.out.println(sol.solution(new int[] { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 }));
    }

    private static class Solution {
        public int solution(int[] a) {
            // 양쪽 끝은 항상 가능
            int answer = 2;

            int min = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] < min) {
                    min = a[i];
                    answer++;
                }
            }

            min = a[a.length - 1];
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i] < min) {
                    min = a[i];
                    answer++;
                }
            }

            return answer - 1;
        }
    }
}
