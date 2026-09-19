package day41_50.day46;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Lv3 연습문제. 다단계 칫솔 판매
public class ToothbrushSales {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] enroll = new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = new String[] {"young", "john", "tod", "emily", "mary"};
        int[] amount = new int[] {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(sol.solution(enroll, referral, seller, amount)));

        enroll = new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        referral = new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        seller = new String[] {"sam", "emily", "jaimie", "edward"};
        amount = new int[] {2, 3, 5, 4};
        System.out.println(Arrays.toString(sol.solution(enroll, referral, seller, amount)));
    }

    private static class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int len = enroll.length;
            int[] answer = new int[len];

            // enroll 정보를 이름-인덱스 관계로 저장할 HashMap 선언
            Map<String, Integer> index = new HashMap<>();

            for (int i = 0; i < enroll.length; i++) {
                index.put(enroll[i], i);
            }

            // 판매에 성공한 인원만큼 반복
            for (int i = 0; i < seller.length; i++) {
                // 각 판매자의 판매 수익
                int price = amount[i] * 100;

                String name = seller[i];

                // 추천인(부모)이 존재할동안 반복
                while (true) {

                    // 미리 저장한 HashMap에서 해당 이름의 인덱스 찾기
                    int idx = index.get(name);

                    // 수익 저장하기
                    answer[idx] += price - price / 10;

                    // 추천인 찾기
                    name = referral[idx];

                    // 10% 나누기
                    price = price / 10;

                    // 추천인이 없으면 반복 종료
                    if (price == 0 || name.equals("-")) {
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
