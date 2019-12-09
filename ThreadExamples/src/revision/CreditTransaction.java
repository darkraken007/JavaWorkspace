package revision;

public class CreditTransaction implements Runnable
{
private Transaction tr;
private int amount;

public CreditTransaction(Transaction tr, int amount)
{
    this.tr = tr;
    this.amount = amount;
}

@Override
public void run()
{
   try
{
    tr.credit( amount );
}
catch( InterruptedException e )
{
    // TODO Auto-generated catch block
    e.printStackTrace();
}
    
}
}
