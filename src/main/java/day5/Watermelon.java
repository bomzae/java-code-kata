package day5;

// Lv2 31. 수박수박수박수박수
public class Watermelon {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4));
        System.out.println(sol.solution(3));
    }

    private static class Solution {
        public String solution(int n) {
            String answer = "";
            for(int i = 0; i < n; i++) {
                answer += (i % 2 == 0) ? "수" : "박";
            }

            return answer;
        }
    }
}
