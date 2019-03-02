package problem_4_2;

import java.io.*;
import java.util.Scanner;

public class FileMain {

    public static void main(String[] args) {

        File file = new File("src/main/java/problem_4_2/input.txt");
        Scanner scanner;
        int n;
        int [] datas;
        try {
            scanner = new Scanner(file);
            n = scanner.nextInt();
            System.out.println("n=" + n);
            datas = new int[n];

            if (!scanner.hasNext()) {
                return;
            }

            for (int i = 0; i < n; i++) {
                datas[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 이진 트리 만들기
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.setValues(datas);
        binarySearchTree.printTreeInfo();
    }
}