package linkedList.test;

import linkedList.api.LinkedList;
import linkedList.api.Node;

public class LinkedListTest
{

    public static void main( String[] args )
    {
        LinkedList list = new LinkedList( new Node( 3, null ) );
        list.insert( new Node( 2, null ) );
        list.insertAt( new Node(1,null), 2 );
        list.insert( new Node(3,null) );
        list.insert( new Node(7,null) );
        System.out.println( list );
        list.reverseKNodes( 2 );
        System.out.println( list );

    }

}
