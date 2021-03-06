package programmers.id42586;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Stack<Integer> functions = new Stack<>();
        List<Integer> answerList = new ArrayList<>();

        int firstFunctionDevelopPeriod = 0;
        for (int i = 0; i < progresses.length; i++) {
            if (firstFunctionDevelopPeriod == 0) {
                // 처음 한 번 확인
                firstFunctionDevelopPeriod = getDevelopPeriod(progresses[i], speeds[i]);
                functions.push(progresses[i]);
                continue;
            }

            int period = getDevelopPeriod(progresses[i], speeds[i]);
            if (firstFunctionDevelopPeriod < period) {
                // 배포의 첫 기능 작업일보다 현재 기능 작업일이 더 걸리면 배포일을 새로 잡음
                firstFunctionDevelopPeriod = period;
                answerList.add(functions.size());
                functions.clear();
                functions.add(progresses[i]);
                continue;
            }

            functions.add(progresses[i]);
        }

        if (!functions.isEmpty()) {
            // 아직 기능이 스택에 남아있는 경우 작업일에 반영
            answerList.add(functions.size());
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    /**
     * 개발 작업 기간을 구하는 메소드
     * @param progress 작업 진도
     * @param speed 작업 속도
     * @return 남은 개발 작업 기간
     */
    private int getDevelopPeriod(int progress, int speed) {
        return (int) Math.ceil((100 - (double) progress) / (double) speed);
    }
}