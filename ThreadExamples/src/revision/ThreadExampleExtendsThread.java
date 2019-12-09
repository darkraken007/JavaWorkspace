package revision;

public class ThreadExampleExtendsThread extends Thread
{

    public ThreadExampleExtendsThread(String name)
    {
        super(name );
    }
    @Override
    public void run()
    {
        System.out.println( "thread name is " + getName() );
    }
}
