package example3;

public class Driver
{

    public static void main(String[] args){
        CounterThread ct = new CounterThread(1);
        Thread t1 = new Thread( ct, "t1" );
        Thread t2 = new Thread(ct, "t2");
        t1.start();
        try
        {
            t1.join();
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t2.start();
    }
}
