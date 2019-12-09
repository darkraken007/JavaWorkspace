package waitNotify;

public class ReadAccount implements Runnable
{

    Account account;
    
    public ReadAccount( Account account )
    {
        super();
        this.account = account;
    }

    @Override
    public void run()
    {
        synchronized(account){
        System.out.println( "waiting for Writer to finish" );
        try
        {
            account.wait();
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

            
            System.out.println( account.getBalance() );
        }
        
        
    }

}
