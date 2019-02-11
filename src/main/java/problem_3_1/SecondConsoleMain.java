package problem_3_1;

import java.util.Scanner;

public class SecondConsoleMain {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("스택의 개수 : ");
        int n = inputReader.nextInt();
        System.out.print("스택의 최대 길이 : ");
        int length = inputReader.nextInt();
        VotileCustomStack stack = new VotileCustomStack(n, length);

        boolean isExit = false;
        while(!isExit) {
            System.out.print("Command[0 - Push, 1 - Pop, 2 - List, 3 - Exit] : ");

            int command = inputReader.nextInt();
            int m;
            switch (command) {
                case 0:
                    if (stack.isFull()) {
                        System.out.println("더 이상 넣을 공간이 없습니다.");
                        break;
                    }

                    System.out.print("몇 번째 스택?");
                    m = inputReader.nextInt();
                    System.out.print("데이터 : ");
                    String data = inputReader.next();
                    stack.push(m, data);
                    break;
                case 1:
                    System.out.print("몇 번째 스택?");
                    m = inputReader.nextInt();
                    stack.pop(m);
                    break;
                case 2:
                    System.out.print("몇 번째 스택?");
                    m = inputReader.nextInt();
                    stack.print(m);
                    break;
                case 3:
                    isExit = true;
                    break;
                default:
                    System.out.println("잘못된 명령입니다. [0~3까지만 입력하세요.]");
                    break;
            }
        }
    }
}