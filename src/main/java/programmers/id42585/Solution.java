package programmers.id42585;

/**
 * - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있습니다.
 * - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓습니다.
 * - 각 쇠막대기를 자르는 레이저는 적어도 하나 존재합니다.
 * - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.
 *
 * (a) 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 '()'으로 표현합니다. 또한 모든 '()'는 반드시 레이저를 표현합니다.
 * (b) 쇠막대기의 왼쪽 끝은 여는 괄호 '('로, 오른쪽 끝은 닫힌 괄호 ')'로 표현됩니다.
 */

class Solution {

    public int solution(String arrangement) {
        int answer = 0;
        int currentCnt = 0;
        int addValue = 0;
        boolean isLaser = false;
        for (int i = 0; i < arrangement.length(); i++) {
            switch (arrangement.charAt(i)) {
                case '(':
                    isLaser = true;
                    currentCnt++;
                    addValue++;
                    break;
                case ')':
                    if (isLaser) {
                        currentCnt--;
                        addValue--;
                        isLaser = false;
                        answer += (currentCnt + addValue);
                    } else {
                        currentCnt--;
                    }
                    addValue = 0;
                    break;
            }
        }
        return answer;
    }
}