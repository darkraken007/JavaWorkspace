package revision;

public class DeadLockDriver
{

    public static void main( String[] args )
    {
        ResourceA  a = new ResourceA( 0 );
        ResourceB b = new ResourceB( 0 );
        
        Thread t1 = new Thread(new DeadLockThread( a, b, true ));
        Thread t2 = new Thread(new DeadLockThread2( a, b, false ));
        t1.start();
        t2.start();

    }

}
