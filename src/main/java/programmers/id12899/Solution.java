package programmers.id12899;

import java.util.Stack;

class Solution {
    public String solution(int n) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            int mok = n / 3;
            int remain = n % 3;

            if (remain == 0) {
                mok = mok - 1;
                remain = 4;
            }

            stack.push(remain);

            if (mok <= 3) {
                if (mok == 3) {
                    mok = 4;
                }

                if (mok != 0) {
                    stack.push(mok);
                }
                break;
            }

            n = mok;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        answer = builder.toString();
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " -> " + solution.solution(i));
        }
    }
}