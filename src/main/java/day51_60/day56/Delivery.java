package day51_60.day56;

import java.util.*;

// Lv2 연습문제. 배달
public class Delivery {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] road = new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        System.out.println(sol.solution(5, road, 3));

        road = new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        System.out.println(sol.solution(6, road, 4));
    }

    private static class Solution {

        static class Node implements Comparable<Node> {
            int index;
            int distance;

            Node(int index, int distance) {
                this.index = index;
                this.distance = distance;
            }

            @Override
            public int compareTo(Node other) {
                return this.distance - other.distance;
            }
        }

        public int solution(int N, int[][] road, int K) {
            int answer = 0;

            // 1번 마을에서 각 마을까지의 최단 거리
            int[] town = new int[N + 1];

            Arrays.fill(town, 500001);
            town[1] = 0;

            // 최단 거리가 가장 짧은 Node부터 꺼냄
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(1, 0));

            while (!pq.isEmpty()) {

                Node now = pq.poll();

                // 이미 더 짧은 경로가 있다면 무시
                if (now.distance > town[now.index]) {
                    continue;
                }

                // 모든 도로 확인
                for (int i = 0; i < road.length; i++) {

                    // 현재 마을이 도로의 출발지인 경우
                    if (road[i][0] == now.index) {

                        int idx = road[i][1];
                        int cost = now.distance + road[i][2];

                        if (cost < town[idx]) {
                            town[idx] = cost;
                            pq.offer(new Node(idx, cost));
                        }
                    }

                    // 현재 마을이 도로의 도착지인 경우
                    else if (road[i][1] == now.index) {

                        int idx = road[i][0];
                        int cost = now.distance + road[i][2];

                        if (cost < town[idx]) {
                            town[idx] = cost;
                            pq.offer(new Node(idx, cost));
                        }
                    }
                }
            }

            // K 이하로 갈 수 있는 마을의 개수
            for (int i = 1; i <= N; i++) {
                if (town[i] <= K) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
