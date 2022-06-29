package kvbdev;

public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (execute(i)) {
                callback.onDone("Task " + i + " is done");
            } else {
                errorCallback.onError("Task " + i + " is failed");
            }
        }
    }

    private boolean execute(int taskNum) {
        return taskNum == 33 ? false : true;
    }

}
