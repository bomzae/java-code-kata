package day41_50.day47;

// Lv3 연습문제. 가장 긴 팰린드롬
public class Palindrome {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("abcdcba"));
        System.out.println(sol.solution("abacde"));
    }

    private static class Solution
    {
        public int solution(String s)
        {
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {

                // 팰린드롬이 홀수인 경우
                int left = i;
                int right = i;

                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                    int len = right - left + 1;
                    if (len > answer) {
                        answer = len;
                    }

                    left--;
                    right++;
                }

                // 팰린드롬이 짝수인 경우
                left = i;
                right = i + 1;

                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                    int len = right - left + 1;
                    if (len > answer) {
                        answer = len;
                    }

                    left--;
                    right++;
                }

            }

            return answer;
        }
    }
}
