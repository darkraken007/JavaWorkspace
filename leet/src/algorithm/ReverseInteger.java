package algorithm;

public class ReverseInteger
{

    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }
    
    
    public int reverse(int x) {

        String s = Integer.toString( x );
        int max = Math.pow( 10, s.length()-1 ) > (double)Integer.MAX_VALUE ? 0: (int)Math.pow( 10, s.length()-1 );
        for(int i= s.length()-1;i>0;i--){
            
            Integer.parseInt( s.charAt( i ) );
        }
    }

}
