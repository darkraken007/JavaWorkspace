package deadlockexample;

public class DeadLockThread implements Runnable
{
    public Object o1;
    public Object o2;
    
    public DeadLockThread(Object o1, Object o2)
    {
        this.o1 = o1;
        this.o2 = o2;
    }
    
    @Override
    public void run()
    {
        work();
        System.out.println( "aquiring lock on object o1 " + Thread.currentThread().getName() );
        
        synchronized(o1){
            System.out.println( "aquired lock on object o1 " + Thread.currentThread().getName() );
            work();
            System.out.println( "aquiring lock on object o2 by " + Thread.currentThread().getName() );
            synchronized(o2){
                System.out.println( "aquired lock on object o2 by " + Thread.currentThread().getName() );
                work();
            }
            System.out.println( "released lock on object o2 " + Thread.currentThread().getName());
        }
        System.out.println( "released lock on object o1 " + Thread.currentThread().getName() );
        
    }
    
    private void work()
    {
        try
        {
            Thread.sleep( 30000 );
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
}
