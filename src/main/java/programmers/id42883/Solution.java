package programmers.id42883;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int length = number.length();
        int start = 0;
        StringBuilder builder = new StringBuilder();

        /*
         * 숫자의 자리수 - 뺄 자리수(얻어야 할 숫자의 자리 수)이므로 해당 개수만큼 최대숫자를 뽑아서 구하면 O(n ^ 2)으로 끝낼 수 있음
         */
        for (int i = length - k - 1; i >= 0; i--) {
            /*
             * 탐색의 끝 위치는 지금 현재 뽑는 자리에 따라 점차 끝에 가도록 함
             * 예를 들자면 i가 만약 1이라면 내가 뽑아야하는 숫자는 적어도 끝에서 2번째 자리 안에서는 뽑아야 함(뽑아야할 숫자가 2자리가 남은 상황임)
             */
            int idx = getBigNumIdx(number, start, length - 1 - i);
            builder.append(number.charAt(idx));
            start = idx + 1;
        }

        answer = builder.toString();
        return answer;
    }

    /**
     * 범위 내에서 최대 숫자가 있는 위치를 얻는 메소드
     * @param number 숫자
     * @param start 탐색을 시작할 위치
     * @param end 탐색이 끝나는 위치
     * @return 범위 내의 최대 숫자가 있는 위치
     */
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