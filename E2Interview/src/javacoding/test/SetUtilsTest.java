package javacoding.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import javacoding.SetUtils;

public class SetUtilsTest
{
    
    @Test
    void testUnion(){
        SetUtils<Integer> setUtil = new SetUtils<>();
        
        Set<Integer> A = new HashSet<>();
        A.add( 1 );
        A.add( 2 );
        
        Set<Integer> B = new HashSet<>();
        B.add( 3 );
        B.add( 4 );
        
        Set<Integer> C = setUtil.setUnion( A, B );
    }

}
