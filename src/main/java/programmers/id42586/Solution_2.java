package programmers.id42586;

import java.util.ArrayList;
import java.util.List;

class Solution_2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> answerList = new ArrayList<>();

        int currentDistributionIndex = 0;
        int firstFunctionDevelopPeriod = 0;
        for (int i = 0; i < progresses.length; i++) {
            if (firstFunctionDevelopPeriod == 0) {
                // 처음 한 번 확인
                firstFunctionDevelopPeriod = getDevelopPeriod(progresses[i], speeds[i]);
                answerList.add(1);
                continue;
            }

            int period = getDevelopPeriod(progresses[i], speeds[i]);
            if (firstFunctionDevelopPeriod < period) {
                // 배포의 첫 기능 작업일보다 현재 기능 작업일이 더 걸리면 배포일을 새로 잡음
                currentDistributionIndex++;
                firstFunctionDevelopPeriod = period;
                answerList.add(1);
                continue;
            }

            // 배포 기능 추가
            answerList.set(currentDistributionIndex, answerList.get(currentDistributionIndex) + 1);
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