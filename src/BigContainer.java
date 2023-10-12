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
    protected void expand(){
        Task[] aux = new Task[len * 2];
        java.lang.System.arraycopy(arr, 0, aux, 0, len);
        arr = aux;
        len *= 2;
    }

    protected void contract(){
        Task[] aux = new Task[len / 2];
        java.lang.System.arraycopy(arr, 0, aux, 0, len / 2);
        arr = aux;
        len /= 2;
    }
    public void add(Task task){
        if(lastIndex + 1 >= size()){
            expand();
        }
        arr[++lastIndex] = task;
    }
    public abstract Task remove();
}
