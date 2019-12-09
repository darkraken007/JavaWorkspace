package revision;

public class DebitTransaction implements Runnable
{
private Transaction tr;
private int amount;

public DebitTransaction(Transaction tr, int amount)
{
    this.tr = tr;
    this.amount = amount;
}

@Override
public void run()
{
   try
{
    tr.debit( amount );
}
catch( InterruptedException e )
{
    // TODO Auto-generated catch block
    e.printStackTrace();
}
    
}
}