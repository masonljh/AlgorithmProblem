package programmers.id12980;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n >= 2) {
            if (n % 2 == 1) {
                ans++;
            }
            n /= 2;
        }

        ans++;
        return ans;
    }
}