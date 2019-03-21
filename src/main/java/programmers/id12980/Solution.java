package programmers.id12980;

public class Solution {
    public int solution(int n) {
        // 처음에 무조건 한 번은 점프 뛰어야함
        int ans = 1;

        while(n >= 2) {
            if (n % 2 == 1) {
                // 나머지가 있다면 배터리 1칸 사용(점프)
                ans++;
            }
            // 순간이동(거리는 반으로)
            n /= 2;
        }
        return ans;
    }
}