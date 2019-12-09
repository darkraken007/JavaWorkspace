package javacoding;

import java.util.HashSet;
import java.util.Set;


public class SetUtils<T>
{

    public Set<T> setUnion( Set<T> A, Set<T> B )
    {
        Set<T> C = new HashSet<>();
        C.addAll( A );
        C.addAll( B );

        return C;
    }


    public Set<T> setIntersection( Set<T> A, Set<T>B){
        
        Set<T> C = new HashSet<>();
        
        for( T a : A )
        {
           if(B.contains( a )){
               C.add( a );
           }
        }
        
        
        return C;
    }
    
    public Set<T> setDifference( Set<T> A, Set<T>B){
        
        
        A.removeAll( B );
        
        return A;
    }
}
