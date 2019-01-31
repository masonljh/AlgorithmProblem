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

        //                image[start][j];
        //                image[j][end - 1];
        //                image[end - 1][end - 1 - j];
        //                image[end - 1 - start][start];
        int mid = Math.round((float) n / 2);
        int end = n;
        for (int start = 0; start < mid; start++) {
            System.out.println(start + " / " + end);
            for (int j = start; j < end - 1; j++) {
                System.out.println("j=" + j);
                System.out.println("(" + start + "," + j + ") <-> (" + j + "," + (end - 1) + ")");
                swap(image[start][j], image[j][end - 1]);
                printImages(n, image);
                System.out.println();
                System.out.println("(" + (end - 1 - j) + "," + start + ") <-> (" + (end - 1) + "," + (end - 1 - j) + ")");
                swap(image[end - 1 - j][start], image[end - 1][end - 1 - j]);
                printImages(n, image);
                System.out.println();
                System.out.println("(" + start + "," + j + ") <-> (" + (end - 1) + "," + (end - 1 - j) + ")");
                swap(image[start][j], image[end - 1][end - 1 - j]);
                printImages(n, image);
                System.out.println();
            }
            end--;
        }
    }

    private static void printImages(int n, Pixel[][] image) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(image[i][j].tempValue + " ");
            }
            System.out.println();
        }
    }

    private static void swap(Pixel pixel, Pixel otherPixel) {
        int tempValue = pixel.tempValue;
        pixel.tempValue = otherPixel.tempValue;
        otherPixel.tempValue = tempValue;
//        Pixel temp = pixel;
//        pixel = otherPixel;
//        otherPixel = temp;
    }

    static class Pixel {
        byte[] values;
        int tempValue;
    }

}