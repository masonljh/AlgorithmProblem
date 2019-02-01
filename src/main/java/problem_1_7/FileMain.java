package problem_1_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileMain {

    public static void main(String[] args) {

        Pixel[][] image;
        int n;

        try {
            File file = new File("src/main/java/problem_1_7/input.txt");
            Scanner scanner = new Scanner(file);
            n = scanner.nextInt();
            image = new Pixel[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    image[i][j] = new Pixel();
                    image[i][j].tempValue = scanner.nextInt();
                }
            }
        } catch (IOException e) {
            return;
        }

        /**
         *  정사각형을 기준으로 봤을 때
         *  왼쪽 위 점은 image[start][j]
         *  오른쪽 위 점은 image[j][end - 1]
         *  왼쪽 아래 점은 image[end - 1 - j + start][start]
         *  오른쪽 아래 점은 image[end - 1][end - 1 - j + start]
         */

        System.out.println("Input Image");
        printImages(n, image);

        int mid = Math.round((float) n / 2);
        int end = n;
        for (int start = 0; start < mid; start++) {
//            System.out.println(start + " / " + end);
            for (int j = start; j < end - 1; j++) {
                /**
                 *  90도 회전은 아래와 같은 로직으로 동작한다.
                 *  1. 위 두 점끼리 바꿈
                 *  2. 아래 두 점끼리 바꿈
                 *  3. 왼쪽 위 점과 오른쪽 아래 점을 바꿈
                 */
//                System.out.println("j=" + j);
//                System.out.println("(" + start + "," + j + ") <-> (" + j + "," + (end - 1) + ")");
                swap(image[start][j], image[j][end - 1]);
//                printImages(n, image);
//                System.out.println();
//                System.out.println("(" + (end - 1 - j + start) + "," + (start) + ") <-> (" + (end - 1) + "," + (end - 1 - j + start) + ")");
                swap(image[end - 1 - j + start][start], image[end - 1][end - 1 - j + start]);
//                printImages(n, image);
//                System.out.println();
//                System.out.println("(" + start + "," + j + ") <-> (" + (end - 1) + "," + (end - 1 - j + start) + ")");
                swap(image[start][j], image[end - 1][end - 1 - j + start]);
//                printImages(n, image);
//                System.out.println();
            }
            end--;
        }

        System.out.println();
        System.out.println("Output Image");
        printImages(n, image);
    }

    private static void printImages(int n, Pixel[][] image) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(image[i][j].tempValue + " ");
            }
            System.out.println();
        }
    }

    /**
     * 점의 pixel 값을 바꿔주는 함수
     *
     * @param pixel 대상 픽셀
     * @param otherPixel 바꾸려는 픽셀
     */
    private static void swap(Pixel pixel, Pixel otherPixel) {
        // byte 배열이라면 deepCopy 해서 바꾸는 형태로 해야할듯
        int tempValue = pixel.tempValue;
        pixel.tempValue = otherPixel.tempValue;
        otherPixel.tempValue = tempValue;
    }

    static class Pixel {
        byte[] values;
        int tempValue;
    }

}