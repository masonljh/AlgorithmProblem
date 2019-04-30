package programmers.id43162;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (computers[i][i] == 0) {
                continue;
            }

            answer++;
            computers[i][i] = 0;
            updateConnectedComputers(n, computers, i);
        }
        return answer;
    }

    private void updateConnectedComputers(int n, int[][] computers, int i) {
        for (int j = 0; j < n; j++) {
            if (j == i) {
                continue;
            }

            if (computers[i][j] == 1) {
                computers[j][j] = 0;
                computers[i][j] = 0;
                computers[j][i] = 0;
                updateConnectedComputers(n, computers, j);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}}));
        System.out.println();

        System.out.println(solution.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}}));
        System.out.println();

        System.out.println(solution.solution(5, new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1}}));
        System.out.println();

        System.out.println(solution.solution(5, new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1}}));
        System.out.println();

        System.out.println(solution.solution(5, new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1}}));
        System.out.println();

        System.out.println(solution.solution(5, new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 0, 1}}));
        System.out.println();

        System.out.println(solution.solution(5, new int[][]{
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1}}));
        System.out.println();
    }
}