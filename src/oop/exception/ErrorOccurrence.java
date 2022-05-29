package oop.exception;

public class ErrorOccurrence {
    public static void main(String[] args) {
        recursiveWithTryCatch();
//        recursive();
    }

    static void recursiveWithTryCatch() throws StackOverflowError {
        try {
            recursiveWithTryCatch();
        } catch (StackOverflowError e) {
            System.out.println("메모리 초과 StackOverflowError 발생");
        }
    }

    static void recursive() {
        recursive();
    }
}
