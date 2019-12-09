package threadLocal;

public class LocalDriver
{

    public static void main( String[] args ) throws InterruptedException
    {
       ThreadLocaleExample tle = new ThreadLocaleExample();
       Thread t1 = new Thread( tle, "thead 1" );
       Thread t2 = new Thread(tle, "thread 2");
       t1.start();
       t2.start();
    }

}
