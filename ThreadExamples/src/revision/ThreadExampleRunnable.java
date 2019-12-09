package revision;

public class ThreadExampleRunnable implements Runnable
{
    public ThreadExampleRunnable(Account account)
    {
        // TODO Auto-generated constructor stub
    }

    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue()
        {
            
            return 0;
        }
    };
    
    @Override
    public void run()
    {
        try
        {
            threadLocal.set( (int)(Math.random()*40) );
            Thread.sleep( 5000 );
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println( "thread is running" + threadLocal.get());
        
    }

}
