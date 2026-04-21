package day39;

// Lv4 69. 성격 유형 검사하기
public class PersonalityTest {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] survey = new String[] {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = new int[] {5, 3, 2, 7, 5};
        System.out.println(sol.solution(survey, choices));

        survey = new String[] {"TR", "RT", "TR"};
        choices = new int[] {7, 1, 3};
        System.out.println(sol.solution(survey, choices));
    }

    private static class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            char[] type = new char[] {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
            int[] score = new int[8];

            int idx = -1;
            for (int i = 0; i < survey.length; i++) {
                if (choices[i] == 4) {
                    continue;
                }

                for (int j = 0; j < type.length; j++) {
                    char character = choices[i] < 4 ? survey[i].charAt(0) : survey[i].charAt(1);

                    if (type[j] == character) {
                        idx = j;
                        break;
                    }
                }

                if (choices[i] < 4) {
                    score[idx] += 4 - choices[i];
                } else {
                    score[idx] += choices[i] - 4;
                }
            }

            for (int i = 0; i < type.length; i += 2) {
                if (score[i] == score[i + 1]) {
                    answer += type[i];
                    continue;
                }

                idx = Math.max(score[i], score[i + 1]) == score[i] ? i : i + 1;
                answer += type[idx];
            }

            return answer;
        }
    }
}
