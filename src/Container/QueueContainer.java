package Container;

import Domain.Task;

import java.util.EmptyStackException;

public class QueueContainer extends BigContainer {
    public QueueContainer() {
        super();
    }

    public Task remove() {
        if (isEmpty()) {
            throw (new EmptyStackException());
        }
        Task toReturn = arr[0];
        for (int i = 0; i < lastIndex; ++i) {
            arr[i] = arr[i + 1];
        }
        --lastIndex;
        if (size() <= 1)
            return toReturn;
        if (lastIndex < size() / 2) {
            contract();
        }
        return toReturn;
    }
}
