package callablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableFutureDriver
{

    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        ExecutorService executor = Executors.newFixedThreadPool( 10 );
        List<Future<String> > ret = new ArrayList<Future<String>>();
        MyCallableFuture fut = new MyCallableFuture();
        for(int i=0;i<10;i++){
            ret.add( executor.submit( fut ));
        }
        
        for(int i=0;i<10;i++){
            
            System.out.println( ret.get( i ).get() );
        }
        executor.shutdown();
    }

}
