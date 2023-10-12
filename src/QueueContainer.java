import java.util.EmptyStackException;

public class QueueContainer extends BigContainer {
    public QueueContainer(){
        super();
    }

    public Task remove(){
        if (isEmpty()){
            throw(new EmptyStackException());
        }
        Task toReturn = arr[0];
        for(int i=0; i<=lastIndex; ++i){
            arr[i] = arr[i+1];
        }
        --lastIndex;
        if(lastIndex < size() / 2){
            Task[] aux = new Task[size() / 2];
            java.lang.System.arraycopy(arr, 0, aux, 0, size() / 2);
            arr = aux;
        }
        return toReturn;
    }

    public void add(Task task){
        if(lastIndex + 1 >= size()){
            Task[] aux = new Task[size() * 2];
            java.lang.System.arraycopy(arr, 0, aux, 0, size());
            arr = aux;
        }
        arr[++lastIndex] = task;
    }
}
