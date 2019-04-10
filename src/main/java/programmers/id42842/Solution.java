package programmers.id42842;

class Solution {
    public int[] solution(int brown, int red) {
        int brownWidth = (brown - 6) / 2 + 2;
        int brownHeight = 3;
        int redArea = (brownWidth - 2) * (brownHeight - 2);

        while (redArea != red) {
            brownWidth--;
            brownHeight++;
            redArea = (brownWidth - 2) * (brownHeight - 2);
        }

        int[] answer = {brownWidth, brownHeight};
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(10, 2);
        System.out.println(answer[0] + " / " + answer[1]);

        answer = solution.solution(8, 1);
        System.out.println(answer[0] + " / " + answer[1]);

        answer = solution.solution(24, 24);
        System.out.println(answer[0] + " / " + answer[1]);
    }
}