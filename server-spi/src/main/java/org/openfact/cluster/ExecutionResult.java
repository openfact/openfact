package org.openfact.cluster;

public class ExecutionResult<T> {

    private final boolean executed;
    private final T result;

    private ExecutionResult(boolean executed, T result) {
        this.executed = executed;
        this.result = result;
    }

    public static <T> ExecutionResult<T> executed(T result) {
        return new ExecutionResult<>(true, result);
    }

    public static <T> ExecutionResult<T> notExecuted() {
        return new ExecutionResult<>(false, null);
    }

    public boolean isExecuted() {
        return executed;
    }

    public T getResult() {
        return result;
    }
    
}
