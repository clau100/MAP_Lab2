public abstract class BigContainer implements Container{
    Task[] arr;
    int len;
    int lastIndex;
    public BigContainer(){
        arr = new Task[2];
        len = 2;
        lastIndex = -1;
    }
    public int size(){
        return len;
    }
    public boolean isEmpty(){
        return lastIndex == -1;
    }
    public abstract Task remove();
    public abstract void add(Task task);
}
