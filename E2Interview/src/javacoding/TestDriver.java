package javacoding;

import java.util.HashSet;
import java.util.Set;

public class TestDriver
{

    public static void main( String[] args )
    {
        SetUtils<String> setUtil = new SetUtils<>();
        
        Set<String> A = new HashSet<>();
        A.add( "d" );
        A.add( "e" );
        A.add( "f" );
        
        Set<String> B = new HashSet<>();
        B.add( "a" );
        B.add( "b" );
        B.add( "c" );
        B.add( "d" );
        
        Set<String> union = setUtil.setUnion( A, B );
        Set<String> intersection = setUtil.setIntersection( A, B );
        Set<String> setDiffAminusB = setUtil.setDifference( A, B );
        Set<String> setDiffBminusA = setUtil.setDifference( B, A );
        
        System.out.println( "union is :" + union );
        System.out.println( "intersection is:" + intersection );
        System.out.println( "A-B is:" + setDiffAminusB );
        System.out.println( "B-A is:" + setDiffBminusA);
           
    }
}
