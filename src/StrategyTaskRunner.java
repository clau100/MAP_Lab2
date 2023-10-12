public class StrategyTaskRunner implements TaskRunner{
    private final Container container;
    StrategyTaskRunner(Strategy strategy){
        TaskContainerFactory taskContainerFactory = TaskContainerFactory.getInstance();
        container = taskContainerFactory.createContainer(strategy);
    }

    public void executeOneTask(){
        container.remove().execute();
    }

    public void executeAll(){
        while(!container.isEmpty()){
            container.remove().execute();
        }
    }

    public void addTask(Task t){
        container.add(t);
    }

    public boolean hasTask(){
        return !container.isEmpty();
    }
}
