package day15;

import java.util.stream.Collectors;

// Lv3 45. 시저 암호
public class CaesarCipher {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("AB", 1));
        System.out.println(sol.solution("z", 1));
        System.out.println(sol.solution("a B z", 4));
    }

    private static class Solution {
        public String solution(String s, int n) {
            String answer = s.chars()
                    .map(c -> {
                        if (c >= 'A' && c <= 'Z') return 'A' + ((c - 'A' + n) % 26);
                        else if (c >= 'a' && c <= 'z') return 'a' + ((c - 'a' + n) % 26);
                        return c;
                    })
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining());

            return answer;
        }
    }
}
