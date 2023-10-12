import java.util.EmptyStackException;

public class StackContainer extends BigContainer{
    public StackContainer(){
        super();
    }
    public Task remove(){
        if(isEmpty()){
            throw(new EmptyStackException());
        }

        Task toReturn = arr[lastIndex];
        lastIndex--;
        if(size() <= 1)
            return toReturn;
        if(lastIndex < size() / 2){
            contract();
        }
        return toReturn;
    }
}
