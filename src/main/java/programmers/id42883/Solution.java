package programmers.id42883;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int length = number.length();
        int start = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = length - k - 1; i >= 0; i--) {
            int idx = getBigNumIdx(number, start, length - 1 - i);
            builder.append(number.charAt(idx));
            start = idx + 1;
        }

        answer = builder.toString();
        return answer;
    }

    private int getBigNumIdx(String number, int start, int end) {
        int max = -1;
        int maxi = -1;
        for (int i = start; i <= end; i++) {
            int num = number.charAt(i) - '0';
            if (num > max) {
                max = num;
                maxi = i;
            }
        }

        return maxi;
    }
}