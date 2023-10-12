public abstract class AbstractTaskRunner implements TaskRunner{
    private final TaskRunner taskRunner;
    public AbstractTaskRunner(TaskRunner taskRunner){
        this.taskRunner = taskRunner;
    }


    public void executeOneTask() {
        taskRunner.executeOneTask();
    }

    public void executeAll() {
        taskRunner.executeOneTask();
    }

    public void addTask(Task t) {
        taskRunner.addTask(t);
    }

    public boolean hasTask() {
        return taskRunner.hasTask();
    }
}
