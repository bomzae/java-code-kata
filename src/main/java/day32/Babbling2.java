package day32;

// Lv3 62. 옹알이2
public class Babbling2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(sol.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }

    private static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            String[] babble = new String[] {"aya", "ye", "woo", "ma"};

            for (String b : babbling) {
                if (check(b, babble, 0, "")) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean check(String word, String[] babble, int idx, String prev) {
            if (word.length() == idx) {
                return true;
            }

            for (String b : babble) {
                if (!b.equals(prev) && word.startsWith(b, idx)) {
                    if (check(word, babble, idx + b.length(), b)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
