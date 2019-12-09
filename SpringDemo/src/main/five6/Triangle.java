package main.five6;

public class Triangle
{
    private String type;
    private int height;

    public Triangle(String type){
        this.type = type;
    }
    
    public Triangle(String type, int height){
        this.type = type;
        this.height = height;
    }
    
    public Triangle(int height){
        this.height = height;
    }

    public int getHeight(){
        
        return this.height;
    }
    public String getType()
    {
        return this.type;
    }


    public void setType( String type )
    {

        this.type = type;
    }


    public void draw()
    {

        System.out.println(getType() + " triangle drawn with height " + getHeight()  );
    }
}
