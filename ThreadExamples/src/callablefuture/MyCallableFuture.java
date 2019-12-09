package callablefuture;

import java.util.concurrent.Callable;

public class MyCallableFuture implements Callable<String>
{

    @Override
    public String call() throws Exception
    {
        Thread.sleep( 3000 );
        return Thread.currentThread().getName();
    }

}
