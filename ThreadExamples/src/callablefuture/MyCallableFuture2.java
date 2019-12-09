package callablefuture;


import java.util.concurrent.Callable;

public class MyCallableFuture2 implements Callable<String> {

    private long waitTime;
    
    public MyCallableFuture2(int timeInMillis){
        this.waitTime=timeInMillis;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

}
