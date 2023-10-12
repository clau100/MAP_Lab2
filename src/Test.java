import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Test {
    public static void main(String[] args){
        MessageTaskTest();
        SortingTaskTest.sortTest();
        QueueContainerTest.queueTest();
        StackContainerTest.stackTest();
        testFactory();
        TaskRunnerTest.runnerTest();
    }
    public static void MessageTaskTest() {
        System.out.println("Testing MessageTask creation:");
        MessageTask mt1 = new MessageTask("subject1", "body1", "from1", "to1", LocalDateTime.now());
        mt1.execute();
        MessageTask mt2 = new MessageTask("subject2", "body2", "from2", "to2", LocalDateTime.now().minusDays(1));
        mt2.execute();
        MessageTask mt3 = new MessageTask("subject3", "body3", "from3", "to3", LocalDateTime.now().plusDays(1));
        mt3.execute();
        MessageTask mt4 = new MessageTask("subject4", "body4", "from4", "to4", LocalDateTime.now().plusMonths(1));
        mt4.execute();
        MessageTask mt5 = new MessageTask("subject3", "body3", "from3", "to3", LocalDateTime.now().minusMonths(1));
        mt5.execute();
        System.out.print("\n\n\n");
    }

    private static class SortingTaskTest extends SortingTask{
        public SortingTaskTest(int[] vector, boolean fastSort) {
            super(vector, fastSort);
        }

        public static void sortTest(){
            int[] scrambled = {10, 7, 5, 3, 2, 6, 1, 4, 9, 8};
            int[] correct = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            SortingTask test1 = new SortingTask(scrambled, true);
            SortingTask test2 = new SortingTask(scrambled, false);

            assert(Arrays.equals(test1.vector, correct));
            assert(Arrays.equals(test1.vector, test2.vector));
        }
    }

    private static class QueueContainerTest extends QueueContainer{
        public static void queueTest(){
            QueueContainer queueContainer = new QueueContainer();
            assert(queueContainer.isEmpty());

            MessageTask test1 = new MessageTask("1", "1", "1", "1", LocalDateTime.now());
            queueContainer.add(test1);
            assert(!queueContainer.isEmpty());
            assert(queueContainer.arr[0].equals(test1));

            queueContainer.add(test1);
            queueContainer.add(test1);
            assert(queueContainer.len == 4);

            queueContainer.remove();
            assert(queueContainer.len == 2);

            queueContainer.remove();
            assert(queueContainer.len == 1);

            queueContainer.remove();
            assert(queueContainer.len == 1);

            try{
                queueContainer.remove();
                assert(false);
            }catch(EmptyStackException ex){
                assert(true);
            }
            assert(queueContainer.isEmpty());
       }
    }
    private static class StackContainerTest extends StackContainer{
        public static void stackTest(){
            StackContainer stackContainer = new StackContainer();
            assert(stackContainer.isEmpty());

            MessageTask test1 = new MessageTask("1", "1", "1", "1", LocalDateTime.now());
            stackContainer.add(test1);
            assert(!stackContainer.isEmpty());

            MessageTask test2 = new MessageTask("2", "2", "2", "2", LocalDateTime.now());
            stackContainer.add(test2);
            assert(stackContainer.size() == 2);

            MessageTask test3 = new MessageTask("3", "3", "3", "3", LocalDateTime.now());
            stackContainer.add(test3);
            assert(stackContainer.size() == 4);

            Task rm = stackContainer.remove();
            assert(rm.equals(test3));
            assert(stackContainer.size() == 2);

            rm = stackContainer.remove();
            assert(rm.equals(test2));
            assert(stackContainer.size() == 1);

            rm = stackContainer.remove();
            assert(rm.equals(test1));
            assert(stackContainer.size() == 1);

            try{
                stackContainer.remove();
                assert(false);
            }catch (EmptyStackException ex){
                assert(true);
            }

            assert(stackContainer.isEmpty());
        }
    }
    private static void testFactory(){
        TaskContainerFactory taskContainerFactory = TaskContainerFactory.getInstance();
        Container queue = taskContainerFactory.createContainer(Strategy.FIFO);
        assert(queue.getClass() == QueueContainer.class);

        Container stack = taskContainerFactory.createContainer(Strategy.LIFO);
        assert(stack.getClass() == StackContainer.class);
    }
    private static class TaskRunnerTest{
        public static void runnerTest(){
            testStack();
            testQueue();
            testPrinter();
            testDelay();
        }

        private static void testStack(){
            System.out.println("Stack:");
            StrategyTaskRunner strategyTaskRunner = new StrategyTaskRunner(Strategy.valueOf("LIFO"));

            testRun(strategyTaskRunner);
        }

        private static void testQueue(){
            System.out.println("Queue:");
            StrategyTaskRunner strategyTaskRunner = new StrategyTaskRunner(Strategy.valueOf("FIFO"));

            testRun(strategyTaskRunner);
        }

        private static void testRun(TaskRunner strategyTaskRunner){
            MessageTask test1 = new MessageTask("1", "1", "1", "1", LocalDateTime.now());
            MessageTask test2 = new MessageTask("2", "2", "2", "2", LocalDateTime.now());
            MessageTask test3 = new MessageTask("3", "3", "3", "3", LocalDateTime.now());

            strategyTaskRunner.addTask(test1);
            System.out.println("Added 1");
            strategyTaskRunner.addTask(test2);
            System.out.println("Added 2");
            strategyTaskRunner.addTask(test3);
            System.out.println("Added 3");

            strategyTaskRunner.executeAll();
            System.out.print("\n\n\n");
        }

        private static void testPrinter(){
            System.out.println("Printer:");
            TaskRunner printer = new PrinterTaskRunner(new StrategyTaskRunner(Strategy.valueOf("FIFO")));
            testRun(printer);
        }

        private static void testDelay(){
            System.out.println("Delay:");
            TaskRunner delay = new DelayTaskRunner(new StrategyTaskRunner(Strategy.valueOf("LIFO")));
            testRun(delay);
        }
    }
}