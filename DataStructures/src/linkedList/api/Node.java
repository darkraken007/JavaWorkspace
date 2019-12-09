package linkedList.api;

public class Node
{

    private int data;
    private Node next;


    public Node( int data, Node next )
    {
        this.data = data;
        this.next = next;
    }
    
    public Node getNext(){
        
        return this.next;
    }
    
    public int getData(){
        
        return this.data;
    }
    
   public void setNext(Node N){
       this.next = N;
   }
   
   @Override
public boolean equals( Object obj )
{
    if(obj instanceof Node){
        if(((Node)obj).getData() == this.getData()){
            return true;
        }
    }
    return false;
}
}
