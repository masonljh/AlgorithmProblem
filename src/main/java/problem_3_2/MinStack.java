package problem_3_2;

class MinStack {

    private int [] arrays;
    private int [] minArrays;
    private int currentIdx;

    MinStack(int length) {
        arrays = new int[length];
        minArrays = new int[length];
        currentIdx = -1;
    }

    boolean isFull() {
        return currentIdx == arrays.length - 1;
    }

    boolean isEmpty() {
        return currentIdx < 0;
    }

    void push(int value) {
        if (currentIdx < 0) {
            currentIdx++;
            arrays[currentIdx] = value;
            minArrays[currentIdx] = value;
            return;
        }

        if (minArrays[currentIdx] > value) {
            minArrays[currentIdx + 1] = value;
        } else {
            minArrays[currentIdx + 1] = minArrays[currentIdx];
        }

        currentIdx++;
        arrays[currentIdx] = value;
    }

    void pop() {
        // @TODO : (jonghyo) 굳이 초기화가 필요하다면 추가가 필요함
        currentIdx--;
    }

    int min() {
        return minArrays[currentIdx];
    }
}
