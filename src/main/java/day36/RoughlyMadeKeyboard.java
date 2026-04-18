package day36;

import java.util.Arrays;

// Lv4 66. 대충 만든 자판
public class RoughlyMadeKeyboard {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] keymap = new String[] {"ABACD", "BCEFD"};
        String[] targets = new String[] {"ABCD", "AABB"};
        System.out.println(Arrays.toString(sol.solution(keymap, targets)));

        keymap = new String[] {"AA"};
        targets = new String[] {"B"};
        System.out.println(Arrays.toString(sol.solution(keymap, targets)));

        keymap = new String[] {"AGZ", "BSSS"};
        targets = new String[] {"ASA", "BGZ"};
        System.out.println(Arrays.toString(sol.solution(keymap, targets)));
    }

    private static class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            int[] press = new int[26];
            Arrays.fill(press, Integer.MAX_VALUE);

            for (int i = 0; i < keymap.length; i++) {
                for (int j = 0; j < keymap[i].length(); j++) {
                    int idx = keymap[i].charAt(j) - 'A';
                    press[idx] = Math.min(j + 1, press[idx]);
                }
            }

            for (int i = 0; i < targets.length; i++) {
                int sum = 0;
                boolean flag = true;

                for (int j = 0; j < targets[i].length(); j++) {
                    int idx = targets[i].charAt(j) - 'A';

                    if (press[idx] == Integer.MAX_VALUE) {
                        flag = false;
                        break;
                    }

                    sum += press[idx];
                }

                answer[i] = flag ? sum : -1;
            }

            return answer;
        }
    }
}
