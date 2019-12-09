package threadpoolExecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandlerExample implements RejectedExecutionHandler
{

    @Override
    public void rejectedExecution( Runnable r, ThreadPoolExecutor executor )
    {
        System.out.print( r.toString() + " is Rejected" );
        
    }

}
