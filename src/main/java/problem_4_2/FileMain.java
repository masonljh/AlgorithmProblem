package problem_4_2;

import java.io.*;
import java.util.Scanner;

public class FileMain {

    public static void main(String[] args) {

        File file = new File("src/main/java/problem_4_2/input.txt");
        Scanner scanner = null;
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
        int cnt = 0;
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setMode(BinaryTree.ARRAY_MODE);
        binaryTree.setValues(datas);
        binaryTree.printAllNode();
        /*while (cnt < n) {
            binaryTree.addNode(new Node(datas[idx]));
            cnt++;
        }*/
    }
}