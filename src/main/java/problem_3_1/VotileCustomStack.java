package problem_3_1;

public class VotileCustomStack implements Stack {

    private int cnt;
    private int maxLength;
    private int currentSize;
    private Element [] arrays;
    private int [] startIndexes;

    VotileCustomStack(int n, int length) {
        arrays = new Element[length];
        startIndexes = new int[n];
        for (int i = 0; i < n; i++) {
            startIndexes[i] = -1;
        }
        maxLength = length;
        cnt = n;
        currentSize = 0;
    }

    @Override
    public boolean isFull() {
        return currentSize == maxLength;
    }

    @Override
    public boolean isFull(int n) {
        // 사용하지 않음
        return currentSize == maxLength;
    }

    @Override
    public boolean isEmpty(int n) {
        return startIndexes[n - 1] < 0;
    }

    @Override
    public void push(int n, String data) {
        if (n > cnt) {
            System.out.println("해당 스택은 존재하지 않습니다.");
            return;
        }

        insertElement(new Element(n, data));
        currentSize++;
        sortArray();
    }

    private void insertElement(Element addedElement) {
        for (int i = 0; i < maxLength; i++) {
            if (arrays[i] == null) {
                arrays[i] = addedElement;
                break;
            }
        }
    }

    @Override
    public void pop(int n) {
        if (n > cnt) {
            System.out.println("해당 스택은 존재하지 않습니다.");
            return;
        }

        if (isEmpty(n)) {
            System.out.println(n + "번째 스택은 비어있습니다.");
            return;
        }

        deleteElement(n);
        currentSize--;
        sortArray();
    }

    private void deleteElement(int n) {
        for (int i = maxLength - 1; i >= 0; i--) {
            if (arrays[i].getStackNum() == n) {
                arrays[i] = null;
                break;
            }
        }
    }

    @Override
    public void print(int n) {
        for (int i = 0; i < currentSize; i++) {
            if (arrays[i].getStackNum() == n) {
                System.out.print(arrays[i].getData() + " ");
            }
        }
        System.out.println();
    }

    private void sortArray() {
        Element insertedElement = arrays[currentSize - 1];
        for (int i = currentSize - 2; i >= currentSize; i--) {
            Element currentElement = arrays[i];
            if (currentElement.getStackNum() <= insertedElement.getStackNum()) {
                break;
            }

            currentElement.swap(insertedElement);
            insertedElement = currentElement;
        }
    }

    private class Element {
        private int stackNum;
        private String data;

        Element(int stackNum, String data) {
            this.stackNum = stackNum;
            this.data = data;
        }

        int getStackNum() {
            return stackNum;
        }

        void setStackNum(int stackNum) {
            this.stackNum = stackNum;
        }

        String getData() {
            return data;
        }

        void setData(String data) {
            this.data = data;
        }

        public void swap(Element other) {
            int tempStackNum = this.stackNum;
            String tempData = this.data;

            this.stackNum = other.getStackNum();
            this.data = other.getData();

            other.setStackNum(tempStackNum);
            other.setData(tempData);
        }
    }
}
