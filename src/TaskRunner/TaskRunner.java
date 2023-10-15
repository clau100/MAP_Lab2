package TaskRunner;

import Domain.Task;

public interface TaskRunner {
    void executeOneTask();

    void executeAll();

    void addTask(Task t);

    boolean hasTask();
}
