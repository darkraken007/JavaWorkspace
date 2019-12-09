package callablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskDriver
{

    public static void main(String[] args) throws InterruptedException, ExecutionException{
        
        ExecutorService exServ = Executors.newFixedThreadPool( 10 );
        
        MyCallableFuture2 cal = new MyCallableFuture2(2000);
        MyCallableFuture2 cal2 = new MyCallableFuture2( 3000 );
        
        FutureTask<String> ft1 = new FutureTask<String>( cal );
        FutureTask<String> ft2 = new FutureTask<String>( cal2 );
        
        exServ.submit( ft1 );
        exServ.submit( ft2 );
        
        while(true){
            
            if(ft1.isDone() && ft2.isDone()){
                System.out.println( "Done" );
                exServ.shutdown();
                return;
            }
            
            if(!ft1.isDone()){
                //wait indefinitely for future task to complete
                System.out.println("FutureTask1 output="+ft1.get());
                }
                
                System.out.println("Waiting for FutureTask2 to complete");
                String s;
                try
                {
                    s = ft2.get(200L, TimeUnit.MILLISECONDS);
                    if(s !=null){
                        System.out.println("FutureTask2 output="+s);
                    }
                }
                catch( TimeoutException e )
                {
                   
                }

        }
        
        
    }
}
