package programmers.id43238;

class Solution {
    public long solution(int n, int[] times) {
        long minTime = 1;
        long maxTime = 0;
        long realN = unsigned32(n);
        for (int time : times) {
            maxTime = Math.max(maxTime, unsigned32(time) * realN);
        }
        long answer = maxTime;

        while (minTime < maxTime) {
            long mid = Math.round(((double) minTime + (double) maxTime) / 2);
            // 만약 처리가능한 사람 수라면
            long totalCnt = 0;

            for (int time : times) {
                totalCnt += mid / unsigned32(time);
            }

            if (totalCnt == realN) {
                if (answer > mid) {
                    answer = mid;
                }

                if (mid <= maxTime) {
                    maxTime--;
                }
            } else if (totalCnt >= realN) {
                maxTime = mid - 1L;
                if (answer > mid) {
                    answer = mid;
                }
            } else {
                minTime = mid + 1L;
            }
        }

        return answer;
    }

    private long unsigned32(int n) {
        return n & 0xFFFFFFFFL;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[]{7, 10}));
        System.out.println(solution.solution(6, new int[]{6, 10}));
        System.out.println(solution.solution(6, new int[]{8, 10}));
        System.out.println(solution.solution(6, new int[]{4, 10}));
        System.out.println(solution.solution(11, new int[]{3, 4, 10}));
        System.out.println(solution.solution(5, new int[]{1, 1, 10}));
        System.out.println(solution.solution(5, new int[]{1, 1, 1}));
        System.out.println(solution.solution(5, new int[]{2, 2, 9}));
    }
}