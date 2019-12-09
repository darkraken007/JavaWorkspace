package revision;

public class Account
{

    private volatile int balance;
    private boolean isUnderMaintenance;
    
    public Account(int balance)
    {
        this.balance = balance;
        this.isUnderMaintenance = false;
    }
    public void addBalance(int amount){
        
        balance = balance + amount;
    }
    
    public int getBalance(){
        
        return balance;
    }
    public boolean isUnderMaintenance()
    {
        return isUnderMaintenance;
    }
    public void setUnderMaintenance( boolean isUnderMaintenance )
    {
        this.isUnderMaintenance = isUnderMaintenance;
    }
}
