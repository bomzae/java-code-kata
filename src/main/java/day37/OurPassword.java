package day37;

// Lv4 67. 둘만의 암호
public class OurPassword {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("aukks", "wbqd", 5));
    }

    private static class Solution {
        public String solution(String s, String skip, int index) {
            String answer = "";

            for (int i = 0; i < s.length(); i++) {
                char alphabet = s.charAt(i);

                for (int j = 0; j < index; j++) {
                    alphabet += 1;
                    if (alphabet > 'z') {
                        alphabet = 'a';
                    }

                    if (skip.indexOf(alphabet) >= 0) {
                        j--;
                    }
                }
                answer += alphabet;
            }

            return answer;
        }
    }
}
