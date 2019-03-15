package programmers.id42747;

import java.util.Arrays;

/**
 * 이거 왜 이렇게 짰을까..... ㅜㅜ 반성반성
 */
class Solution3 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        int length = citations.length;
        int currentIdx = 0;
        for (int i = 0; i <= length - 1; i++) {
            while (i > citations[currentIdx]) {
                // 현재 i보다 더 크거나 같은 인용숫자를 만날 때까지 증가시킴
                currentIdx++;
            }

            if (i <= length - currentIdx && i >= currentIdx) {
                // i가 문제의 조건을 만족하면 답임
                answer = i;
            }

            if (currentIdx == length - 1) {
                // 이 경우에는 밑으로 들어가면 안 됨
                continue;
            }

            // 중복되는 게 있을 때 현재 index를 미리 중복되는 숫자보다 큰 숫자로 이동하도록 함
            while (currentIdx < length - 1 && citations[currentIdx] == citations[currentIdx + 1] && i == citations[currentIdx]) {
                currentIdx++;
            }
        }
        return answer;
    }
}