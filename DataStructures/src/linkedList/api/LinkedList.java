package linkedList.api;

public class LinkedList
{

    private Node head;
    
    public LinkedList(Node head){
        
        this.head = head;
    }
    
    @Override
    public String toString()
    {
        Node node = head;
        StringBuffer bf = new StringBuffer();
        while(null != node){
            bf.append( node.getData() + "->"  );
            node = node.getNext();
        }
        
       bf.append( "null" );
       
       return bf.toString();
    }
    
    public void insert(Node N){
        
        Node node = head;
        head = N;
        head.setNext( node );
    }
    
    public void insertAtEnd(Node N){
        Node node = head;
        while( null != node.getNext()){
            node = node.getNext();
        }
        node.setNext( N );
    }
    
    public void insertAt(Node N,int pos){
        if( 0 == pos){
            this.insert(N);
            return;
        }
        Node next = head;
        Node current = null;
        for(int i =1; i<=pos; i++){
            if(next == null){
                throw new IndexOutOfBoundsException();
            }
            current = next;
            next = next.getNext();

        }
        current.setNext( N );
        N.setNext( next );
        
        
    }
    
    public void delete(Node N){
        Node node = head;
        Node previous = null;
        while(node.getNext() != null){
            if(N.equals( node )){
                delete(node,previous);
                return;
            }
            previous = node;
            node = node.getNext();
        }
    }
    
    public void deleteAt(int pos){
        Node node = head;
        Node previous = null;
        for(int i=0; i<pos;i++){
            previous = node;
            node = node.getNext();
        }
        if(node == null){
            throw new IndexOutOfBoundsException();
        }
        delete( node,previous );
    }

    private void delete( Node node, Node previous )
    {
       if(previous == null){
           this.head = node.getNext();
           node.setNext( null );
           return;
       }
       Node next  = node.getNext();
       previous.setNext( next );
       node.setNext( null );
        
    }
    
    private Node getNodeAt(int pos){
        
        Node node = head;
        for(int i=0;i<pos;i++){
            if(null == node){
                throw new IndexOutOfBoundsException();
            }
            node = node.getNext();
        }
        
        return node;
        
        
        
    }
    
    public void swap(int pos1, int pos2){
        
        Node node = head;
        Node previous = null;
        Node node1 = null,node2 = null,prev1 = null,prev2 = null;
        for(int i=0;node!=null;i++){
            if(i == pos1){
               node1 =node;
               prev1 = previous;
            }
            if(i == pos2){
                node2 = node;
                prev2 = previous;
            }
            if(node1 == null || node2 == null){
                throw new IndexOutOfBoundsException();
            }
            else{
                if(prev1!=null){
                    prev1.setNext(node2);
                }
                node1.setNext( node2.getNext() );
                if(prev2!=null){
                    prev2.setNext( node1 );
                }
                node2.setNext( node1.getNext() );
            }
            previous = node;
            node = node.getNext();
        }
        
        
        
    }
    
    public Node reverseKNodes(int k, Node node1){
        Node node = node1;
        Node previous = null;
        Node current = null;
        Node tail = null;
        for(int i=0; i<k && node!=null;i++){
            if(i==0){
                tail = node;
            }
            current = node;
            node = node.getNext();
            current.setNext( previous );
            previous = current;
        }
        if(null!=node){
        tail.setNext( reverseKNodes( 2, node ) );}
        return previous;
    }
    public void reverse(){
        Node node = head;
        Node previous = null;
        Node current = null;
        while(node.getNext() != null){
            current = node;
            node = node.getNext();
            current.setNext( previous );
            previous = current;
        }
        this.head = node;
    }

    public void reverseKNodes( int i )
    {
        head = reverseKNodes( i, head );
        
    }
}
