package io.github.agonxhaferi.springcqrs.result;

public record Result<T, E>(T value, E error, boolean isSuccess) {

    public static <T, E> Result<T, E> ok(T value) {
        return new Result<>(value, null, true);
    }

    public static <T, E> Result<T, E> err(E error) {
        return new Result<>(null, error, false);
    }

    public boolean isFailure() {
        return !isSuccess;
    }

    public T unwrap() {
        if (!isSuccess) throw new IllegalStateException("Called unwrap on an Error Result");
        return value;
    }
}