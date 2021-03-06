package problem_1_8;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileMainFirst {

    public static void main(String[] args) {

        int[][] mat;
        int[][] result;
        int m;
        int n;

        try {
            File file = new File("src/main/java/problem_1_8/input.txt");
            Scanner scanner = new Scanner(file);
            m = scanner.nextInt();
            n = scanner.nextInt();

            System.out.println(m + " / " + n);

            mat = new int[n][m];
            result = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = scanner.nextInt();
                    result[i][j] = mat[i][j];
                }
            }
        } catch (IOException e) {
            return;
        }

        System.out.println("Input");
        printMat(n, m, mat);

        setZeroMat(n, m, mat, result);

        System.out.println();
        System.out.println("Output");
        printMat(n, m, result);
    }

    private static void setZeroMat(int n, int m, int[][] mat, int[][] result) {
        /*
         * 무조건 기존의 mat 배열에서 0이 발견되면 상하좌우를 0으로 만든다.
         * 효율성은 전혀 고려 안 하는 방법이다.
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 0) {
                    continue;
                }

                // @NOTE: (jonghyo) 이게 제일 무식한 방법일 것 같다.
                for (int k = 0; k < n; k++) {
                    result[k][j] = 0;
                }

                for (int k = 0; k < m; k++) {
                    result[i][k] = 0;
                }
            }
        }
    }

    private static void printMat(int n, int m, int[][] mat) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}