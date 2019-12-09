package revision;

public class DeadLockThread2
    implements Runnable
{
    private ResourceB B;
    private ResourceA A;
    private boolean isReady;


    public DeadLockThread2( ResourceA A, ResourceB B, Boolean b )
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
                synchronized( B )
                {
                    System.out.println( "waiting for B from Thread2" );
                    B.wait();
                    System.out.println( "aquiredLock on B from Thread2" );
                    Thread.sleep( 5000 );
                }
                synchronized( A )
                {
                    System.out.println( "waiting for A from Thread2" );
                    A.wait();
                    System.out.println( "aquiredLock on A from Thread2" );
                }
            }
            catch( InterruptedException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            isReady = false;
            synchronized( B )
            {
                B.notify();
                System.out.println( "Released Lock on B from Thread2" );
            }
            synchronized( A )
            {
                A.notify();
                System.out.println( "Released Lock on A from Thread2" );
            }
            isReady = true;
        }

    }

}
