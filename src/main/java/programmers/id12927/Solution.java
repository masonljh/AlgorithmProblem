package programmers.id12927;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        int length = works.length;
        Arrays.sort(works);

        int end = length - 1;
        int start = length - 1;
        start = getUpdatedStart(works, start);
        printAllWorks(n, works);

        while (n > 0 && works[start] > 0) {
            for (int i = start; i <= end; i++) {
                if (n == 0) {
                    break;
                }

                n--;
                works[i]--;
            }

            if (start == 0) {
                continue;
            }

            start = getUpdatedStart(works, start);
            printAllWorks(n, works);
        }

        for (int i = 0; i < length; i++) {
            answer += works[i] * works[i];
        }
        return answer;
    }

    private int getUpdatedStart(int[] works, int start) {
        for (int i = start - 1; i >= 0; i--) {
            if (works[i] < works[start]) {
                break;
            }

            start = i;
        }
        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[]{4, 3, 3}));
        System.out.println(solution.solution(1, new int[]{2, 1, 2}));
        System.out.println(solution.solution(3, new int[]{1, 1}));
    }

    private void printAllWorks(int n, int[] works) {
        System.out.println(n + "번째");
        for (int i = 0; i < works.length; i++) {
            System.out.print(works[i] + " ");
        }
        System.out.println();
    }
}