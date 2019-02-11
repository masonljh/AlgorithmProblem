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
            // 스택에 값이 없었다면 입력받은 값을 스택과 최소값 배열에 넣고 index를 증가시킴
            currentIdx++;
            arrays[currentIdx] = value;
            minArrays[currentIdx] = value;
            return;
        }

        // 스택에 값이 있는 경우 마지막 값 비교
        if (minArrays[currentIdx] > value) {
            // 새로 입력받은 값이 최소값인 경우
            minArrays[currentIdx + 1] = value;
        } else {
            // 새로 입력받은 값이 최소값이 아닌 경우
            minArrays[currentIdx + 1] = minArrays[currentIdx];
        }

        // 스택에 쌓고 인덱스 증가
        currentIdx++;
        arrays[currentIdx] = value;
    }

    void pop() {
        // @TODO : (jonghyo) 굳이 초기화가 필요하다면 추가가 필요함
        currentIdx--;
    }

    int min() {
        // 최소값은 최소값 배열의 현재 index로 리턴
        return minArrays[currentIdx];
    }
}
