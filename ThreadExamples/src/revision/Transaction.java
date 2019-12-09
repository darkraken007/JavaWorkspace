package revision;

public class Transaction
{

    private Account account;


    public Transaction( Account account )
    {
        this.account = account;
    }


    private void doWait()
    {
        synchronized( account )
        {
            if( account.isUnderMaintenance() )
            {
                try
                {
                    account.wait();
                }
                catch( InterruptedException e )
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    private void doNotify()
    {

        synchronized( account )
        {
            account.notifyAll();
        }
    }


    public void debit( int amount ) throws InterruptedException
    {
        System.out.println( "initiate debit wait" );
        doWait();
        System.out.println( "wait debit over" );
        this.account.addBalance( -1 * amount );
        Thread.sleep( 5000 );
    }


    public void credit( int amount ) throws InterruptedException
    {
        System.out.println( "initiate credit wait" );
        doWait();
        System.out.println( "wait credit over" );
        this.account.addBalance( -1 * amount );
        Thread.sleep( 5000 );
    }
    
    public void setUnderMaintenance(boolean b) throws InterruptedException{
        if(!b){
            System.out.println( "setting under maintenance" );
            account.setUnderMaintenance( b );
            Thread.sleep( 5000 );
            doNotify();
        }
        account.setUnderMaintenance( b );
    }
}
