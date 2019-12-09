package example3;

public class CounterThread implements Runnable
{
    private int counter;

    public CounterThread( int i )
    {
        counter = i;
    }

    @Override
    public void run()
    {
        while(counter<10){
            counter++;
            System.out.println(Thread.currentThread().getName() + " counter value = " + counter );
        }
       
       
        
        
    }

}
