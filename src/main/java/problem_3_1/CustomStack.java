package problem_3_1;

public class CustomStack {

    private int cnt;
    private int maxLength;
    private String [] arrays;
    private int [] indexes;

    CustomStack(int n, int length) {
        arrays = new String[n * length];
        indexes = new int[n];
        maxLength = length;
        for (int i = 0; i < n; i++) {
            indexes[i] = -1;
        }
        cnt = n;
    }

    boolean isFull(int n) {
        return indexes[n - 1] == maxLength - 1;
    }

    private boolean isEmpty(int n) {
        return indexes[n - 1] < 0;
    }

    void push(int n, String data) {
        indexes[n - 1]++;
        System.out.println(indexes[n - 1] + " / " + getRealIdx(n));
        arrays[getRealIdx(n)] = data;
    }

    void pop(int n) {
        if (isEmpty(n)) {
            System.out.println(n + "번째 스택은 비어있습니다.");
            return;
        }

        arrays[getRealIdx(n)] = null;
        indexes[n - 1]--;
    }

    private int getRealIdx(int n) {
        return indexes[n - 1] * cnt + n - 1;
    }

    public void print(int n) {
        for (int i = n - 1; i <= getRealIdx(n); i += cnt) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

    public void printAll() {
        for (int i = 0; i < maxLength * cnt; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }
}
