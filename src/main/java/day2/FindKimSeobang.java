package day2;

public class FindKimSeobang {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] s = {"Jane", "Kim"};
        System.out.println(sol.solution(s));
    }

    private static class Solution {
        public String solution(String[] seoul) {
            String answer = "";
            int index = 0;

            for (int i = 0; i < seoul.length; i++) {
                if (seoul[i].equals("Kim")) {
                    index = i;
                    break;
                }
            }
            answer = String.format("김서방은 %d에 있다", index);

            return answer;
        }
    }
}
