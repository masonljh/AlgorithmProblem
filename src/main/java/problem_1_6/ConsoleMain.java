package problem_1_6;

import java.util.Scanner;

public class ConsoleMain {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Input: ");

        String str = inputReader.next();

        System.out.println("============================");
        System.out.println("Output");

        // 입력이 null 혹은 빈 문자열인 경우 끝냄
        if (str == null || str.isEmpty()) {
            return;
        }

        char preCh = str.charAt(0);
        int cnt = 0;

        for (char ch : str.toCharArray()) {
            if (ch == preCh) {
                // 기존 문자와 같다면 카운트만 올림
                cnt++;
            } else {
                // 기존 문자와 다르다면 출력 후 값도 출력
                System.out.print(preCh);
                System.out.print(cnt);
                preCh = ch;
                cnt = 1;
            }
        }

        System.out.print(preCh);
        System.out.print(cnt);
    }

}