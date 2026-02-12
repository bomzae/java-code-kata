package day3;

// Lv1 27. 핸드폰 번호 가리기
public class MaskingPhoneNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("01033334444"));
        System.out.println(sol.solution("027778888"));
    }

    private static class Solution {
        public String solution(String phone_number) {
            String answer = "";
            int len = phone_number.length() - 4;

            for (int i = 0; i < len ; i++) answer += "*";
            answer += phone_number.substring(len, len + 4);

            return answer;
        }
    }
}
