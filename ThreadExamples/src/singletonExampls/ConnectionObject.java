package singletonExampls;

public class ConnectionObject
{
    private static ConnectionObject connection;
    private static Object mutex = new Object();
    private ConnectionObject()
    {
        
    }
    
    public static ConnectionObject getConnection(){
        //un necessary synchronization if connection object is created so we add one more if condition before synchronized block
        if(null == connection){
        
        
        synchronized(mutex){
            if(null ==connection){
                
                connection = new ConnectionObject();
            }
        }
        }
        return connection;
    }
    
}
