package problem_3_1;

public class VotileCustomStack implements Stack {

    private int cnt;
    private int maxLength;
    private int currentSize;
    private Element [] arrays;
    private int [] sizes;

    VotileCustomStack(int n, int length) {
        arrays = new Element[length];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            sizes[i] = 0;
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
        return sizes[n - 1] == 0;
    }

    @Override
    public void push(int n, String data) {
        if (n > cnt) {
            System.out.println("해당 스택은 존재하지 않습니다.");
            return;
        }

        insertElement(new Element(n, data));
        sizes[n - 1]++;
    }

    private void insertElement(Element addedElement) {
        int addedPosition = 0;
        for (int i = currentSize - 1; i >= 0; i--) {
            if (arrays[i].getStackNum() <= addedElement.getStackNum()) {
                addedPosition = i + 1;
                break;
            }
        }

        for (int i = addedPosition; i < currentSize; i++) {
            Element element = arrays[i];
            element.swap(addedElement);
        }

        currentSize++;
        arrays[currentSize - 1] = addedElement;
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
        sizes[n - 1]--;
    }

    private void deleteElement(int n) {
        int deletedPosition = -1;
        for (int i = currentSize - 1; i >= 0; i--) {
            if (arrays[i].getStackNum() == n) {
                arrays[i] = null;
                deletedPosition = i;
                break;
            }
        }

        if (deletedPosition == -1) {
            return;
        }

        currentSize--;
        if (currentSize - deletedPosition >= 0)
            System.arraycopy(arrays, deletedPosition + 1, arrays, deletedPosition, currentSize - deletedPosition);
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
