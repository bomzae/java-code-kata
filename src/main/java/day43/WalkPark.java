package day43;

import java.util.*;

// Lv4 73. 공원 산책
public class WalkPark {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] park = new String[] {"SOO","OOO","OOO"};
        String[] routes = new String[] {"E 2","S 2","W 1"};
        System.out.println(Arrays.toString(sol.solution(park, routes)));

        park = new String[] {"SOO","OXX","OOO"};
        routes = new String[] {"E 2","S 2","W 1"};
        System.out.println(Arrays.toString(sol.solution(park, routes)));

        park = new String[] {"OSO","OOO","OXO","OOO"};
        routes = new String[] {"E 2","S 3","W 1"};
        System.out.println(Arrays.toString(sol.solution(park, routes)));
    }

    private static class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];

            for (int i = 0; i < park.length; i++) {
                int idx = park[i].indexOf('S');

                if (idx >= 0) {
                    answer = new int[] {i, idx};
                    break;
                }
            }

            Map<Character, int[]> direction = new HashMap<>();
            direction.put('N', new int[] {-1, 0});
            direction.put('W', new int[] {0, -1});
            direction.put('E', new int[] {0, 1});
            direction.put('S', new int[] {1, 0});

            for (String route : routes) {
                String[] part = route.split(" ");

                int[] move = direction.get(part[0].charAt(0));
                int repeat = Integer.parseInt(part[1]);

                int height = answer[0];
                int width = answer[1];
                boolean canMove = true;
                for (int i = 0; i < repeat; i++) {
                    height += move[0];
                    width += move[1];

                    if (height < 0 || height >= park.length || width < 0 || width >= park[0].length()) {
                        canMove = false;
                        break;
                    }

                    if (park[height].charAt(width) == 'X') {
                        canMove = false;
                        break;
                    }
                }

                if (canMove) {
                    answer[0] = height;
                    answer[1] = width;
                }
            }

            return answer;
        }
    }
}
