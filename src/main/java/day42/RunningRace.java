package day42;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Lv4 72. 달리기 경주
public class RunningRace {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] players = new String[] {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = new String[] {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(sol.solution(players, callings)));
    }

    private static class Solution {
        public String[] solution(String[] players, String[] callings) {
            Map<String, Integer> rank = new HashMap<>();

            for (int i = 0; i < players.length; i++) {
                rank.put(players[i], i);
            }

            for (String calling : callings) {
                int idx = rank.get(calling);
                String temp;

                temp = players[idx];
                players[idx] = players[idx - 1];
                players[idx - 1] = temp;

                rank.put(players[idx - 1], idx - 1);
                rank.put(players[idx], idx);
            }

            return players;
        }
    }
}
