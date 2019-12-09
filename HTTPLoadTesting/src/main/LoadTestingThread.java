package main;

import connection.UrlConnection;
import reporter.Reporter;


public class LoadTestingThread
    implements Runnable
{
    private String[] urls;
    private int cycles;
    private Reporter reporter;


    public LoadTestingThread( String[] urls, int cycles, Reporter reporter )
    {
        this.urls = urls;
        this.cycles = cycles;
        this.reporter = reporter;
    }


    @Override
    public void run()
    {
        while( cycles > 0 )
        {
            for( String url : urls )
            {
                try
                {
                    if( UrlConnection.connect( url ) )
                    {

                        reporter.addReport( url );
                    }
                    cycles--;
                }
                catch( InterruptedException e )
                {
                    // log that connection failed
                }
            }
        }

    }

}
