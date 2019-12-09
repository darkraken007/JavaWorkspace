package revision;

public class Driver
{

    public static void main( String[] args ) throws InterruptedException
    {
        Account acc = new Account(100);
        Transaction tr = new Transaction( acc );
        Thread t1 = new Thread(new CreditTransaction( tr, 50 ));
        Thread t2 = new Thread(new DebitTransaction( tr, 10 ));
        Thread t3 = new Thread(new MaintenanceTransaction( tr, true ));
        Thread t4 = new Thread(new MaintenanceTransaction( tr, false ));
        t1.start();
        t3.start();
        t2.start();
        t4.start();
                        

    }

}
