package problem_3_2;

import java.util.Scanner;

public class ConsoleMain {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("스택의 최대 길이 : ");
        int length = inputReader.nextInt();
        MinStack stack = new MinStack(length);

        boolean isExit = false;
        while(!isExit) {
            System.out.print("Command[0 - Push, 1 - Pop, 2 - Min, 3 - Exit] : ");

            int command = inputReader.nextInt();
            switch (command) {
                case 0:
                    if (stack.isFull()) {
                        System.out.println("스택이 가득찼습니다.");
                        break;
                    }

                    System.out.print("숫자 : ");
                    int data = inputReader.nextInt();
                    stack.push(data);
                    break;
                case 1:
                    if (stack.isEmpty()) {
                        System.out.println("스택이 비어있습니다.");
                        break;
                    }

                    stack.pop();
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("스택이 비어있습니다.");
                        break;
                    }
                    int min = stack.min();
                    System.out.println("최소값 = " + min);
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