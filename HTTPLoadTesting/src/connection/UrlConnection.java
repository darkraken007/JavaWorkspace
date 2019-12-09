package connection;

public final class UrlConnection
{

    public static boolean connect( String url ) throws InterruptedException
    {
        Thread.sleep( (int)Math.random()*100 );
        return true;
    }
}
