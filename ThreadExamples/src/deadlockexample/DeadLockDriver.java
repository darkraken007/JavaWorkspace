package deadlockexample;

public class DeadLockDriver
{

    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) throws InterruptedException{
        
        Thread t1 = new Thread(new DeadLockThread( o1, o2 ), "t1");
        Thread t2 = new Thread(new DeadLockThread( o2, o1 ),"t2");
        t1.start();
        t1.sleep( 5000 );
        t2.start();
    }
}
