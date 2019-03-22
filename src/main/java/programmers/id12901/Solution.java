package programmers.id12901;

public class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int totalDayCount = 0;
        int currentMonth = 1;
        while (currentMonth < a) {
            totalDayCount += getDayCount(currentMonth);
            currentMonth++;
        }
        totalDayCount += b;

        answer = getDateStr(totalDayCount % 7);
        return answer;
    }

    private int getDayCount(int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return 29;
        }
        return 0;
    }

    private String getDateStr(int mod) {
        switch (mod) {
            case 0:
                return "THU";
            case 1:
                return "FRI";
            case 2:
                return "SAT";
            case 3:
                return "SUN";
            case 4:
                return "MON";
            case 5:
                return "TUE";
            case 6:
                return "WED";
        }
        return null;
    }
}