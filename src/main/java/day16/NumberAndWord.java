package day16;

// Lv3 46. 숫자 문자열과 영단어
public class NumberAndWord {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("one4seveneight"));
        System.out.println(sol.solution("23four5six7"));
        System.out.println(sol.solution("2three45sixseven"));
        System.out.println(sol.solution("123"));
    }

    private static class Solution {
        public int solution(String s) {
            String[] word = {"zero", "one", "two", "three", "four",
                    "five", "six", "seven", "eight", "nine"};

            for (int i = 0; i < word.length; i++) {
                s = s.replace(word[i], String.valueOf(i));
            }

            return Integer.parseInt(s);
        }
    }
}
