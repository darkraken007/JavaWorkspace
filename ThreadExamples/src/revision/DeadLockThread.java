package revision;

public class DeadLockThread
    implements Runnable
{
    private ResourceB B;
    private ResourceA A;
    private boolean isReady;


    public DeadLockThread( ResourceA A, ResourceB B, Boolean b )
    {
        this.A = A;
        this.B = B;
        this.isReady = b;
    }


    @Override
    public void run()
    {
        while( !isReady )
        {
            try
            {
                synchronized( A )
                {
                    System.out.println( "waiting for A from Thread1" );
                    A.wait();
                    System.out.println( "aquiredLock on A from Thread1" );
                    Thread.sleep( 5000 );
                }
                synchronized( B )
                {
                    System.out.println( "waiting for B from Thread1" );
                    B.wait();
                    System.out.println( "aquiredLock on B from Thread1" );
                }
            }
            catch( InterruptedException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            isReady = false;
            synchronized( A )
            {
                A.notify();
                System.out.println( "Released Lock on A from Thread1" );
            }
            synchronized( B )
            {
                B.notify();
                System.out.println( "Released Lock on B from Thread1" );
            }
            isReady = true;
        }

    }

}
