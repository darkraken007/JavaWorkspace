package threadLocal;

public class ThreadLocaleExample implements Runnable
{
    private ThreadLocal<Double> threadLocal = new ThreadLocal<Double>();
    @Override
    public void run()
    {
        threadLocal.set( Math.random()*100);
        System.out.println( "thread local set at thread " + Thread.currentThread().getName() );
        try
        {
            Thread.sleep( 3000 );
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println( Thread.currentThread().getName() +" " + threadLocal.get() );;
    }

    
}
