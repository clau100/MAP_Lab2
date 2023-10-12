import java.util.Objects;

public abstract class Task {
    public String getTaskID() {
        return taskID;
    }

    public String getDescriere() {
        return descriere;
    }

    String taskID;

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    String descriere;
    public Task(String taskID, String descriere){
        this.taskID = taskID;
        this.descriere = descriere;
    }

    public Task(){}

    @Override
    public String toString() {
        return "Task{" +
                "taskID='" + taskID + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(taskID, task.taskID) && Objects.equals(descriere, task.descriere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskID, descriere);
    }
    public abstract void execute();
}
