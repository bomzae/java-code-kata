package day7;

// Lv2 35. 부족한 금액 계산하기
public class CalculateShortfall {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3, 20, 4));
    }

    private static class Solution {
        public long solution(int price, int money, int count) {
            long answer = money;

            for (int i = 1; i <= count; i++) {
                answer -= price * i;
            }

            answer = (answer >= 0) ? 0 : answer * -1;

            return answer;
        }
    }
}
