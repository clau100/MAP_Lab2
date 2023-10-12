import java.util.EmptyStackException;

public class DelayTaskRunner extends AbstractTaskRunner {
    public DelayTaskRunner(TaskRunner taskRunner) {
        super(taskRunner);
    }

    @Override
    public void executeOneTask(){
        try{
            Thread.sleep(3000);
            super.executeOneTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeAll(){
        try{
            while(true){
                Thread.sleep(3000);
                super.executeOneTask();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (EmptyStackException ignored){
        }
    }
}
