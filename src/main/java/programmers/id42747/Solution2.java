package programmers.id42747;

import java.util.Arrays;

class Solution2 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        int length = citations.length;
        // i를 1부터 시작한 이유는 밑에서 조건이 좀 더 깔끔하게 보이도록 하기 위함
        for (int i = 1; i <= length; i++) {
            if (i > citations[length - i]) {
                /*
                 * 이 이상부터는 더 이상 체크할 필요가 없음(h번 이상 인용된 논문이 h편 이상이라는 조건을 만족시킬 수 없음)
                 * 여기서 i는 실질적으로 answer에 해당함
                 */
                break;
            }
            answer++;
        }
        return answer;
    }
}