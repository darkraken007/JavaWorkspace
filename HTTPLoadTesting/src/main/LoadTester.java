package main;

import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import reporter.Reporter;


public class LoadTester
{
    private int numberOfCycles;
    private int numberOfThreads;
    private String[] urls;
    private Reporter reporter;


    public LoadTester( String[] urls, int numberOfThreads, int numberOfCycles )
    {
        reporter = new Reporter( urls );
        this.urls = urls;
        this.numberOfThreads = numberOfThreads;
        this.numberOfCycles = numberOfCycles;
    }


    public void printReport( int interval )
    {
        for( String url : urls )
        {

            System.out.println( url + ":" + (double)reporter.getData().get( url ) / interval );
        }

    }


    public void test() throws InterruptedException
    {
        long startTime = System.currentTimeMillis();

        ExecutorService es = Executors.newCachedThreadPool();

        while( numberOfThreads > 0 )
        {
            es.execute( new LoadTestingThread( urls, numberOfCycles, reporter ) );
            numberOfThreads--;
        }
        es.shutdown();
        Timer timer = new Timer();
        timer.schedule( reporter, 10000, 10000 );

        es.awaitTermination( 10, TimeUnit.MINUTES );
        timer.cancel();

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000;

        System.out.println( "------Total throughPut-----" );

        for( Map.Entry<String, Integer> entry : reporter.getData().entrySet() )
        {

            System.out.println( entry.getKey() + ":" + (double)entry.getValue() / totalTime );

        }

    }
}
