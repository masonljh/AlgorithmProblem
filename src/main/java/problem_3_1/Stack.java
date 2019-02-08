package problem_3_1;

public interface Stack {
    boolean isFull();
    boolean isFull(int n);
    boolean isEmpty(int n);
    void push(int n, String data);
    void pop(int n);
    void print(int n);
}
