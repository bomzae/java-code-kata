package day35;

// Lv4 65. 문자열 나누기
public class SplitString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("banana"));
        System.out.println(sol.solution("abracadabra"));
        System.out.println(sol.solution("aaabbaccccabba"));
    }

    private static class Solution {
        public int solution(String s) {
            int answer = 0;
            int xCnt = 0;
            int notXCnt = 0;
            char x = 0;

            for (int i = 0; i < s.length(); i++) {
                if (xCnt == 0) {
                    x = s.charAt(i);
                    xCnt++;
                    answer++;
                    continue;
                }

                if (s.charAt(i) == x) {
                    xCnt++;
                } else {
                    notXCnt++;
                }

                if (xCnt == notXCnt) {
                    xCnt = 0;
                    notXCnt = 0;
                }
            }

            return answer;
        }
    }
}
