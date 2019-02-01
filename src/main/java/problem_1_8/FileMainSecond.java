package problem_1_8;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileMainSecond {

    public static void main(String[] args) {

        int[][] mat;
        int m;
        int n;
        boolean[] x;
        boolean[] y;

        try {
            File file = new File("src/main/java/problem_1_8/input.txt");
            Scanner scanner = new Scanner(file);
            m = scanner.nextInt();
            n = scanner.nextInt();

            System.out.println(m + " / " + n);

            mat = new int[n][m];

            x = new boolean[m];
            y = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = scanner.nextInt();
                    if (mat[i][j] != 0) {
                        continue;
                    }

                    x[j] = true;
                    y[i] = true;
                }
            }
        } catch (IOException e) {
            return;
        }

        System.out.println("Input");
        printMat(n, m, mat);

        setZeroMat(n, m, mat, x, y);

        System.out.println();
        System.out.println("Output");
        printMat(n, m, mat);
    }

    private static void setZeroMat(int n, int m, int[][] mat, boolean[] x, boolean[] y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!x[j] && !y[i]) {
                    continue;
                }

                mat[i][j] = 0;
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