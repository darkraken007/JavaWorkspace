package main.sevenplus;

public class Color
{
    private String color;
    
    Color(String color){
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor( String color )
    {
        this.color = color;
    }
    
    @Override
    public String toString()
    {
        return color ;
    }
}
