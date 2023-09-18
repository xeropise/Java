package java7.fork_Join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoin_Pool {

    public static void main(String[] args) {
        // 작업 중에 작업 중에 시간이 짧아 대기 중인 쓰레드가 생기는 경우, 다른 쓰레드의 작업을 받아다가 처리하는 것
        // 큰 작업을 작은 단위로 나뉘어서 놀고 있는 쓰레드가 없도록 하는것이지만, 이 역시 적절하게 사용하지 않으면 낭비하는 것이다.
        // 분할 정복 알고리즘을 생각해보자.
        // https://hamait.tistory.com/612
        // https://www.baeldung.com/java-fork-join
        // https://junghyungil.tistory.com/m/103?category=892275
        // https://codechacha.com/ko/java-fork-join-pool/

        // Runnable이나 Callable 인터페이스를 사용하지 않고 ForkJoinTask라는 추상클래스를 사용한다.
        // 대표적으로 ForkJoinTask에서 RecursiveAction(리턴 없음), RecursiveTask(리턴 있음) 라는 형태가 있다.

        //Create ForkJoinPool using the default constructor.
        ForkJoinPool pool = new ForkJoinPool();

        MyRecursiveAction myRecursiveAction =
                //new MyRecursiveAction(15);  // 쪼개지않음
                new MyRecursiveAction(24);        // 쪼개서 쓰레드가 나눠서 동작

        pool.invoke(myRecursiveAction);

    }

    public static class MyRecursiveAction extends RecursiveAction {
        private long workLoad = 0;

        public MyRecursiveAction(long workLoad) {
            this.workLoad = workLoad;
        }

        @Override
        protected void compute() {
            //if work is above threshold, break tasks up into smaller tasks
            if(this.workLoad > 16) {
                System.out.println(Thread.currentThread().getName() + " is Splitting workLoad : " + this.workLoad);
                List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();

                subtasks.addAll(createSubtasks());

                for(RecursiveAction subtask : subtasks){
                    subtask.fork();
                }
            } else {
                System.out.println("Doing workLoad myself: " + this.workLoad);
            }

            System.out.println(Thread.currentThread().getName() + " is Forking");
        }

        private List<MyRecursiveAction> createSubtasks() {
            List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();

            MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);

            MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);

            subtasks.add(subtask1);
            subtasks.add(subtask2);
            return subtasks;
        }
    }
}

