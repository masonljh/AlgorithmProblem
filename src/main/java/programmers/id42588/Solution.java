package programmers.id42588;

class Solution {
    public int[] solution(int[] heights) {
        int length = heights.length;
        int[] answer = new int[length];

        // 어차피 첫 번째 답은 0이어야 함
        for (int i = length - 1; i > 0; i--) {
            int currentHeight = heights[i];     // 현재 탐색 중인 탑의 높이
            for (int j = i - 1; j >= 0; j--) {
                int otherHeight = heights[j];   // 현재 탐색 중인 탑의 앞 쪽 탑의 높이
                if (currentHeight < otherHeight) {
                    // 현재 수신할 수 있는 탑이므로 index 반영
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}