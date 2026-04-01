package day25;

import java.util.Arrays;

// Lv3 55. 카드 뭉치
public class CardDeck {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] cards1 = new String[] {"i", "drink", "water"};
        String[] cards2 = new String[] {"want", "to"};
        String[] goal = new String[] {"i", "want", "to", "drink", "water"};
        System.out.println(sol.solution(cards1, cards2, goal));

        cards1 = new String[] {"i", "water", "drink"};
        cards2 = new String[] {"want", "to"};
        goal = new String[] {"i", "want", "to", "drink", "water"};
        System.out.println(sol.solution(cards1, cards2, goal));
    }

    private static class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            int idx1 = 0;
            int idx2 = 0;
            for (int i = 0; i < goal.length; i++) {
                if (idx1 >= cards1.length) {
                    return remain(idx2, cards2, Arrays.copyOfRange(goal, i, goal.length));
                } else if (idx2 >= cards2.length) {
                    return remain(idx1, cards1, Arrays.copyOfRange(goal, i, goal.length));
                }

                if (goal[i].equals(cards1[idx1])) {
                    idx1++;
                    continue;
                } else if (goal[i].equals(cards2[idx2])) {
                    idx2++;
                    continue;
                }

                return "No";
            }

            return "Yes";
        }

        private String remain(int idx, String[] card, String[] goal) {
            for (int i = 0; i < goal.length; i++) {

                if (idx >= card.length) {
                    return "No";
                }

                if (goal[i].equals(card[idx])) {
                    idx++;
                    continue;
                }

                return "No";
            }

            return "Yes";
        }
    }
}
