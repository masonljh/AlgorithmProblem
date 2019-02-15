package problem_4_1;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileMain {

    public static void main(String[] args) {
        Graph graph;

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/problem_4_1/input.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            graph = new Graph(n);

            int m = Integer.parseInt(tokenizer.nextToken());
            // 노드 정보 입력
            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                graph.addNode(new Node(tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()), n));
            }

            // 그래프가 가진 전체 노드를 출력
            graph.printAllNodes();

            // 그래프가 연결된 정보 세팅
            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                graph.addPath(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
            }

            fileInputStream.close();
        } catch (IOException e) {
            return;
        }

        // 검색 시작
        boolean result = graph.searchPath(0, 5);
        System.out.println(result ? "경로가 존재합니다." : "경로가 존재하지 않습니다.");
    }
}