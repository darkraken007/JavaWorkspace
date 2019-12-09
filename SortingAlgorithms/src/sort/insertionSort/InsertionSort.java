package sort.insertionSort;

import java.util.ArrayList;
import java.util.List;


public class InsertionSort
{

    public static List<Integer> sort( List<Integer> list )
    {

        for( int i = 0; i < list.size(); i++ )
        {
            int key = list.get( i );
            int j = i-1;
            while(j>=0 && list.get( j )>key){
                
                list.set( j+1, list.get( j ) );
                j = j -1;
            }
            list.set( j+1, key );

        }
        return list;

    }


    public static void main( String[] args )
    {

        List<Integer> list = new ArrayList<>();

        list.add( 6 );
        list.add( 4 );
        list.add( 8 );
        list.add( 1 );
        list.add( 10 );
        list.add( 0 );

        System.out.println( sort( list ) );
    }
}
