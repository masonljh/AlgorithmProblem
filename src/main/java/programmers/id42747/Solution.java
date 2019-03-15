package programmers.id42747;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        int length = citations.length;
        while (answer < length && answer < citations[length - answer - 1]) {
            /*
             * h번 이상 인용된 논문이 h편 이상인 조건의 반대가 while 문 안의 조건임
             */
            answer++;
        }
        return answer;
    }
}