package problem_4_2;

public class WrongModeException extends RuntimeException {
    public WrongModeException() {
        super("Current mode cannot suppot this command.");
    }
}
