package waitNotify;

public class DriverWaitNotify
{

    public static void main( String[] args )
    {
        Account acc = new Account( 100, "1222", "kaklask" );
        ReadAccount rd = new ReadAccount( acc );
        WriteBalance wb = new WriteBalance( acc, -1000 );
        Thread rt = new Thread( rd, "read thread " );
        Thread rt1 = new Thread(rd, "read thread 1 ");
        Thread wbt = new Thread( wb, "write thread" );
        
        
        rt.start();
        rt1.start();
        wbt.start();
    }

}
