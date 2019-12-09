package revision;

public class MaintenanceTransaction
    implements Runnable
{
    private Transaction tr;
    private boolean b;
    


    public MaintenanceTransaction( Transaction tr , boolean b)
    {
        this.tr = tr;
        this.b  = b;
    }


    @Override
    public void run()
    {
       try
    {
        tr.setUnderMaintenance( b );
    }
    catch( InterruptedException e )
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        
    }

}
