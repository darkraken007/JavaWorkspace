package reporter;

import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;


public class Reporter
    extends TimerTask
{
    private Map<String, Integer> retrievalMap;
    private int timeElapsed;
    private Map<String, Double> throughPuts;


    public int getTimeElapsed()
    {
        return timeElapsed;
    }


    public void setTimeElapsed( int timeElapsed )
    {
        this.timeElapsed = timeElapsed;
    }


    public Reporter( String[] urls )
    {
        retrievalMap = new HashMap<>();
        throughPuts = new HashMap<>();
        for( String url : urls )
        {
            retrievalMap.put( url, 0 );
        }
        timeElapsed = 0;
    }


    public synchronized void addReport( String url )
    {

        retrievalMap.put( url, retrievalMap.get( url ) + 1 );
    }


    public Map<String, Integer> getData()
    {

        return retrievalMap;
    }


    @Override
    public void run()
    {
        timeElapsed = timeElapsed + 10;
        for( Map.Entry<String, Integer> entry : retrievalMap.entrySet() )
        {

            double prev_throughPut = 0;
            if( null != throughPuts.get( entry.getKey() ) )
            {
                prev_throughPut = throughPuts.get( entry.getKey() );
            }
            double current_throughput =
                ((double)entry.getValue() - (prev_throughPut * (timeElapsed - 10))) / 10;
            System.out.print( entry.getKey() + ":" + current_throughput + "," );
            throughPuts.put( entry.getKey(), (double)entry.getValue() / timeElapsed );

        }
        System.out.println();

    }
}
