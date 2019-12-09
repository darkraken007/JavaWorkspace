package waitNotify;

public class Account
{
    int balance;
    String accNum;
    String name;
    
    
    
    public Account( int balance, String accNum, String name )
    {
        super();
        this.balance = balance;
        this.accNum = accNum;
        this.name = name;
    }
    

    
    public int getBalance()
    {

        return balance;
    }


    public void setBalance( int balance )
    {

        this.balance = balance;
    }
    public String getAccNum()
    {
        return accNum;
    }
    public void setAccNum( String accNum )
    {
        this.accNum = accNum;
    }
    public String getName()
    {
        return name;
    }
    public void setName( String name )
    {
        this.name = name;
    }

}
