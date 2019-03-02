package problem_4_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileMain {

    public static void main(String[] args) {

        File file = new File("src/main/java/problem_4_5/input.txt");
        Scanner scanner;
        int n;
        int [] binarySearchDatas;
        int [] binaryDatas;
        try {
            scanner = new Scanner(file);
            n = scanner.nextInt();
            System.out.println("n=" + n);
            binarySearchDatas = new int[n];
            binaryDatas = new int[n];

            if (!scanner.hasNext()) {
                return;
            }

            for (int i = 0; i < n; i++) {
                binarySearchDatas[i] = scanner.nextInt();
                binaryDatas[i] = binarySearchDatas[i];
            }

            Arrays.sort(binaryDatas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 이진 트리 만들기
        BinaryTree binarySearchTree = new BinaryTree();
        binarySearchTree.setValues(binarySearchDatas, BinaryTree.BINARY_SEARCH_MODE);

        BinaryTree balancedBinaryTree = new BinaryTree();
        balancedBinaryTree.setValues(binaryDatas, BinaryTree.BALANCED_MODE);

        BinaryTree unbalancedBinaryTree = new BinaryTree();
        unbalancedBinaryTree.setValues(binaryDatas, BinaryTree.UNBALANCED_MODE);

        System.out.println("첫번째 이진 탐색 트리 여부 = " + binarySearchTree.isBinarySearchTree());
        System.out.println("두번째 이진 탐색 트리 여부 = " + balancedBinaryTree.isBinarySearchTree());
        System.out.println("세번째 이진 탐색 트리 여부 = " + unbalancedBinaryTree.isBinarySearchTree());
    }
}